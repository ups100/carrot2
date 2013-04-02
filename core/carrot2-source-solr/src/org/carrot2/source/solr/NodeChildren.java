package org.carrot2.source.solr;

import java.util.Iterator;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.common.collect.AbstractIterator;

/**
 * An adapter from {@link NodeList} to an {@link Iterable} over {@link Node}s.
 */
class NodeChildren implements Iterable<Node> {
    NodeList nodeList;
    final int max;

    NodeChildren(Node n) {
        this.nodeList = n.getChildNodes();
        this.max = nodeList.getLength();
    }
    
    @Override
    public Iterator<Node> iterator()
    {
        return new AbstractIterator<Node>() {
            private int position = 0;

            @Override
            protected Node computeNext()
            {
                assert position <= max;
                if (position == max) {
                    return super.endOfData();
                } else {
                    return nodeList.item(position++);
                }
            }
        };
    }
}