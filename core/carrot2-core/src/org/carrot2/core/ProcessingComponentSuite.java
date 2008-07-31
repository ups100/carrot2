package org.carrot2.core;

import java.io.InputStream;
import java.io.Writer;
import java.util.Collections;
import java.util.List;

import org.carrot2.util.CloseableUtils;
import org.carrot2.util.resource.*;
import org.carrot2.util.simplexml.NoClassAttributePersistenceStrategy;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.load.Commit;
import org.simpleframework.xml.load.Persister;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * A set of {@link ProcessingComponent}s used in Carrot2 applications.
 */
@Root(name = "component-suite")
public class ProcessingComponentSuite
{
    @ElementList(name = "sources", entry = "source", required = false)
    private List<DocumentSourceDescriptor> sources;

    @ElementList(name = "algorithms", entry = "algorithm", required = false)
    private List<ProcessingComponentDescriptor> algorithms;

    public ProcessingComponentSuite()
    {
    }

    public ProcessingComponentSuite(List<DocumentSourceDescriptor> sources,
        List<ProcessingComponentDescriptor> algorithms)
    {
        this.algorithms = algorithms;
        this.sources = sources;
    }

    public List<DocumentSourceDescriptor> getSources()
    {
        return sources;
    }

    public List<ProcessingComponentDescriptor> getAlgorithms()
    {
        return algorithms;
    }

    /**
     * Returns all components available in this suite, including data sources, algorithms
     * and any other types.
     */
    public List<ProcessingComponentDescriptor> getComponents()
    {
        return Lists.newArrayList(Iterables.concat(sources, algorithms));
    }
    
    /**
     * Replace missing attributes with empty lists.
     */
    @Commit
    @SuppressWarnings("unused")
    private void postDeserialize()
    {
        if (sources == null) sources = Collections.emptyList();
        if (algorithms == null) algorithms = Collections.emptyList();
    }

    /**
     *
     */
    public static ProcessingComponentSuite deserialize(Resource resource)
        throws Exception
    {
        final InputStream inputStream = resource.open();
        final ProcessingComponentSuite loaded;
        try
        {
            loaded = new Persister().read(ProcessingComponentSuite.class, inputStream);
        }
        finally
        {
            CloseableUtils.close(inputStream);
        }

        return loaded;
    }

    /**
     *
     */
    public static void serialize(ProcessingComponentSuite suite, Writer writer)
        throws Exception
    {
        new Persister(NoClassAttributePersistenceStrategy.INSTANCE).write(suite, writer);
    }
}
