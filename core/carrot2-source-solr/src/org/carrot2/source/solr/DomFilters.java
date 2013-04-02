package org.carrot2.source.solr;

import org.w3c.dom.Node;

import com.google.common.base.Predicate;

/**
 * Certain {@link Node} predicates useful for traversals.
 */
class DomFilters {
    private DomFilters() {}

    public static Predicate<Node> isElement()
    {
        return new Predicate<Node>() {
            @Override
            public boolean apply(Node input)
            {
                return input.getNodeType() == Node.ELEMENT_NODE;
            }
        };
    }

    public static Predicate<Node> nameEquals(final String nodeName)
    {
        return new Predicate<Node>() {
            @Override
            public boolean apply(Node input)
            {
                return input.getNodeName().equals(nodeName);
            }
        };
    }        
}