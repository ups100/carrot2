
/*
 * Carrot2 project.
 *
 * Copyright (C) 2002-2013, Dawid Weiss, Stanisław Osiński.
 * All rights reserved.
 *
 * Refer to the full license file "carrot2.LICENSE"
 * in the root folder of the repository checkout or at:
 * http://www.carrot2.org/carrot2.LICENSE
 */

package org.carrot2.source.solr;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URL;
import java.util.List;

import org.carrot2.core.Cluster;
import org.carrot2.core.attribute.AttributeNames;
import org.carrot2.core.test.DocumentSourceTestBase;
import org.carrot2.source.xml.XmlDocumentSource;
import org.carrot2.util.attribute.AttributeUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.simpleframework.http.core.ContainerServer;
import org.simpleframework.transport.Server;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;

import com.carrotsearch.randomizedtesting.annotations.ThreadLeakLingering;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope.Scope;
import com.google.common.io.Resources;

/**
 * Test cases for {@link XmlDocumentSource}.
 */
@ThreadLeakLingering(linger = 1000)
@ThreadLeakScope(Scope.SUITE)
public class SolrDocumentSourceTest extends DocumentSourceTestBase<SolrDocumentSource>
{
    static Connection connection;
    private static URL dummyResponseUrl; 
    
    @Override
    public Class<SolrDocumentSource> getComponentClass()
    {
        return SolrDocumentSource.class;
    }
    
    private static class OneResponseServer implements Container {
        private byte [] response;

        public OneResponseServer(byte [] response)
        {
            this.response = response;
        }

        @Override
        public void handle(Request req, Response response)
        {
            try {
                final long now = System.currentTimeMillis();
                response.setDate("Date", now);
                response.setDate("Last-Modified", now);
    
                response.setValue("Content-Type", "application/octet-stream");
                response.getOutputStream().write(this.response);
                response.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @BeforeClass
    public static void setupHttpServer() throws Exception {
        byte [] response = Resources.toByteArray(
            Resources.getResource(SolrDocumentSourceTest.class, "solr_4_2.xml"));
        
        Container container = new OneResponseServer(response);
        Server server = new ContainerServer(container);
        connection = new SocketConnection(server);
        SocketAddress address = new InetSocketAddress(/* any */ 0);
        address = connection.connect(address);

        if (address instanceof InetSocketAddress)
        {
            InetSocketAddress addr = (InetSocketAddress) address;
            dummyResponseUrl = new URL("http", addr.getHostName(), addr.getPort(), "/");
        }
    }
    
    @AfterClass
    public static void cleanupHttpServer() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void testReadDocuments()
    {
        processingAttributes.put(AttributeUtils.getKey(
            SolrDocumentSource.class, "serviceUrlBase"), 
            dummyResponseUrl.toExternalForm());
        processingAttributes.put(AttributeNames.QUERY, "fake");

        runQuery();

        assertThat(super.getDocuments()).isNotEmpty();
    }
    
    @Test
    public void testReadClusters()
    {
        processingAttributes.put(AttributeUtils.getKey(
            SolrDocumentSource.class, "serviceUrlBase"), 
            dummyResponseUrl.toExternalForm());
        processingAttributes.put(AttributeUtils.getKey(
            SolrDocumentSource.class, "idFieldName"), 
            "name");
        processingAttributes.put(AttributeNames.QUERY, "fake");

        runQuery();

        @SuppressWarnings("unchecked")
        List<Cluster> clusters = (List<Cluster>) resultAttributes.get(AttributeNames.CLUSTERS);
        assertThat(clusters).isNotEmpty();
    }    
}
