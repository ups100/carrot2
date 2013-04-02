package org.carrot2.source.solr;

import java.util.HashMap;
import java.util.List;

import org.carrot2.source.xml.IDomDecoratorCallback;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Inject numeric document identifiers and references into Solr's highlighter and clustering
 * output. DOM manipulation from Java is *terrible*...
 */
final class InjectDocReferences implements IDomDecoratorCallback
{
    private String idFieldName;

    public InjectDocReferences(String idFieldName)
    {
        this.idFieldName = idFieldName;
    }
    
    @Override
    public void apply(Document doc)
    {
        if (idFieldName != null)
        {
            // Enrich documents with numeric identifiers and link back
            // highlighter and clustering component references based on the 
            // provided ID field's name.

            // collect documents, map their ID field to their generated uid
            final HashMap<String,String> docIds = Maps.newHashMap();
            final List<Node> responseNodes;

            responseNodes = Lists.newArrayList(elementsNamed(doc, "response"));
            for (Node responseNode : responseNodes)
            {
                for (Node resultNode : elementsNamed(responseNode, "result"))
                {
                    for (Node docNode : elementsNamed(resultNode, "doc"))
                    {
                        for (Node propertyNode : Iterables.filter(new NodeChildren(docNode), DomFilters.isElement()))
                        {
                            Node attr = propertyNode.getAttributes().getNamedItem("name");
                            if (attr != null && idFieldName.equals(getTextContent(attr)))
                            {
                                String newDocId = Integer.toString(docIds.size());
                                if (null != docIds.put(getTextContent(propertyNode), newDocId)) {
                                    // Non-unique IDs?
                                    LoggerFactory.getLogger(SolrDocumentSource.class)
                                        .warn("Non-unique values in the ID field: "
                                            + idFieldName);
                                    return;
                                }

                                Attr docIdAttr = doc.createAttribute("_docid");
                                docIdAttr.setNodeValue(newDocId);
                                docNode.getAttributes().setNamedItem(docIdAttr);
                            }
                        }
                    }
                }
            }

            // parse clustering component's output, do the mapping if we have any IDs.
            if (!docIds.isEmpty()) {
                for (Node responseNode : responseNodes)
                {
                    for (Node arrNode : elementsNamed(responseNode, "arr"))
                    {
                        Node attr = arrNode.getAttributes().getNamedItem("name");
                        if (attr != null && attr.getNodeValue().equals("clusters")) {
                            for (Node lstNode : elementsNamed(arrNode, "lst")) {
                                processClusterNode(lstNode, doc, docIds);
                            }
                        }
                    }
                }
            }

            // TODO: parse highlighter's output, do the mapping.
        }
    }

    private void processClusterNode(Node lstNode, Document doc, HashMap<String, String> docIds)
    {
        for (Node n : elementsNamed(lstNode, "arr")) {
            Node attr = n.getAttributes().getNamedItem("name");
            if (attr != null && attr.getNodeValue().equals("docs")) {
                for (Node docNode : elementsNamed(n, "str")) {
                    String ref = getTextContent(docNode);
                    if (ref.length() > 0 && docIds.containsKey(ref)) {
                        Attr docRefIdAttr = doc.createAttribute("_docref");
                        docRefIdAttr.setNodeValue(docIds.get(ref));
                        docNode.getAttributes().setNamedItem(docRefIdAttr);
                    }
                }
            }
        }

        // TODO: process subclusters recursively.
    }

    private Iterable<Node> elementsNamed(Node n, String name)
    {
        return Iterables.filter(new NodeChildren(n),
            Predicates.and(
                DomFilters.isElement(),
                DomFilters.nameEquals(name)));
    }

    /**
     * Text content of a node (non-recursive).
     */
    private String getTextContent(Node n)
    {
        StringBuilder sb = new StringBuilder();
        for (Node child : new NodeChildren(n)) {
            if (child.getNodeType() == Node.TEXT_NODE) {
                sb.append(child.getNodeValue());
            }
        }
        return sb.toString();
    }
}