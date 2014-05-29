package org.carrot2.clustering.suffixtree;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import com.carrotsearch.hppc.BitSet;
import com.carrotsearch.hppc.IntStack;

public class OurSuffixTree {
	ISequence m_seq;
	int[] m_groupBounds;
	IntStack m_docBounds = new IntStack();
	int m_currentDocId = 0;

	public class Node {
		public int id;
		public Map<Integer, Node> children;
		public int start;
		public int len;
		public int docId;
		public Node suffixLink;

		public Node(int id, int start, int len, int docId)
		{
			this.id = id;
			this.children = new Hashtable<Integer, Node>();
			this.start = start;
			this.len = len;
			this.docId = docId;
			this.suffixLink = null;
		}
	};

	/* Structure of a tree */
	public Node m_root;
	ArrayList<Node> m_nodes;
	Node m_previous = null;

	/* Variables used while construction */
	private class ActivePoint {
		Node currentNode;
		Node targetNode;
		int len;
	};

	ActivePoint m_activePoint;
	int m_reminder;
	int m_current;

	public OurSuffixTree(ISequence sequence, int[] groupBounds)
	{
		this.m_seq = sequence;
		this.m_groupBounds = groupBounds;
		this.m_docBounds.add(m_groupBounds, 0, m_groupBounds.length);
	}

	private int generateDocId()
	{
		int newDocId;
		/* count new id */
		if (m_current >= m_docBounds.get(0)) {
			m_docBounds.remove(0);
			newDocId = ++m_currentDocId;
		} else {
			newDocId = m_currentDocId;
		}
		return newDocId;
	}

	private void addSuffixLink(Node n) {
		if (m_previous != null)
			m_previous.suffixLink = n;
		m_previous = n;
	}

	int getToken(int ind) {
		return m_seq.objectAt(ind);
	}

	boolean goDown()
	{
		if (m_activePoint.targetNode.len > 0 && m_activePoint.len >= m_activePoint.targetNode.len) {
			/* we will enter here only when length of edge is fully determined */
			m_current += m_activePoint.targetNode.len;
			m_activePoint.len -= m_activePoint.targetNode.len;
			m_activePoint.currentNode = m_activePoint.targetNode;
			return true;
		}
		return false;
	}

	public void addCurrentToken(int i)
	{
		m_reminder++;
		m_previous = null;

		while (m_reminder > 0) {
			if (m_activePoint.len == 0) m_current = i;
			if (!m_activePoint.currentNode.children.containsKey(getToken(m_current))) {
				/* no such token, we will insert the new one */
				int newDocId = generateDocId();

				/* create new node */
				Node newOne = new Node(m_nodes.size(), m_current, -1, newDocId);
				m_nodes.add(newOne);

				m_activePoint.currentNode.children.put(m_seq.objectAt(m_current), newOne);
				//System.out.println("Nowe dziecko " + (char)m_seq.objectAt(m_current) );
				addSuffixLink(m_activePoint.currentNode);
			} else {
				m_activePoint.targetNode = m_activePoint.currentNode.children.get(getToken(m_current));
				if (goDown()) continue;
				/* check if we have match next token */
				if (getToken(m_activePoint.targetNode.start + m_activePoint.len) ==
						getToken(i)) {
						++m_activePoint.len;
						addSuffixLink(m_activePoint.currentNode);
						break;
				}

				/* We have mismatch so we have to split */
				int newDocId = generateDocId();

				/* remove from children of current node */
				m_activePoint.currentNode.children.remove(getToken(m_activePoint.targetNode.start));

				/* create new nodes in the middle */
				Node midle = new Node(m_nodes.size(), m_activePoint.targetNode.start, m_activePoint.len, newDocId);
				m_nodes.add(midle);

				/* Add to current node */
				m_activePoint.currentNode.children.put(getToken(midle.start), midle);

				/* move forward start of last target node */
				m_activePoint.targetNode.start = m_activePoint.targetNode.start + m_activePoint.len;

				/* add it as first child of new middle node */
				midle.children.put(getToken(m_activePoint.targetNode.start), m_activePoint.targetNode);

				/* Create node for new sentence */
				Node newOne = new Node(m_nodes.size(), i, -1, newDocId);
				m_nodes.add(newOne);

				/* add as second child */
				midle.children.put(getToken(i), newOne);
				//System.out.println("Wyzielono dla "  + (char)m_seq.objectAt(i));

				addSuffixLink(midle);
			}

			--m_reminder;

			if (m_activePoint.currentNode == m_root && m_activePoint.len > 0) {
				--m_activePoint.len;
				m_current = i - m_reminder + 1;
			} else {
				m_activePoint.currentNode = m_activePoint.currentNode.suffixLink != null ?
						m_activePoint.currentNode.suffixLink : m_root;
			}
		}
	}

	public void build()
	{
		m_root = new Node(0, 0, 0, -1);
		m_nodes = new ArrayList<Node>();
		m_nodes.add(m_root);
		m_activePoint = new ActivePoint();
		m_activePoint.currentNode = m_root;
		m_activePoint.len = 0;
		m_reminder = 0;
		//System.out.println("poczatek");

		for (int i = 0; i < m_seq.size(); ++i) {
			addCurrentToken(i);
		}

	}

	public abstract class Visitor {
		public int minCardinality;
		public abstract void visit(Node n, BitSet documents, int lenBefore);
		public Visitor(int minCardinality)
		{
			this.minCardinality = minCardinality;
		}
	};

	void visitNode(Node n, Visitor v, BitSet my_docs, int len)
	{
		BitSet my_childSet = new BitSet();
		/* Check if we have a leaf or not */
		if (n.children.isEmpty()) {
			my_docs.set(n.docId);
		} else {
			int lenBefore = len + n.len;
			for (Node child : n.children.values()) {
				visitNode(child, v, my_childSet, lenBefore);
			}

			my_docs.or(my_childSet);
		}

		if (n != m_root && my_childSet.cardinality() >= v.minCardinality) {
			v.visit(n, my_childSet, len);
		}
	}

	void iterateThroughtTree(Visitor v)
	{
		visitNode(m_root, v, new BitSet(), 0);
	}

	ISequence getSequence()
	{
		return m_seq;
	}


	/* Just for debugging */
	public void printTree(PrintWriter out) {
        out.println("digraph {");
        out.println("\trankdir = LR;");
        out.println("\tedge [arrowsize=0.4,fontsize=10]");
        out.println("\tnode1 [label=\"\",style=filled,fillcolor=lightgrey,shape=circle,width=.1,height=.1];");
        out.println("//------leaves------");
        printLeaves(m_root, out);
        out.println("//------internal nodes------");
        printInternalNodes(m_root, out);
        out.println("//------edges------");
        printEdges(m_root, out);
        out.println("//------suffix links------");
        printSLinks(m_root, out);
        out.println("}");
    }

    void printLeaves(Node n, PrintWriter out) {
        if (n.children.isEmpty())
            out.println("\tnode"+n.id+" [label=\"\",shape=point]");
        else {
            for (Node child : n.children.values())
                printLeaves(child, out);
        }
    }

    void printInternalNodes(Node n, PrintWriter out) {
        //if (n != m_root && !n.children.isEmpty())
        	if ( !n.children.isEmpty())
            out.println("\tnode"+n.id+" [label=\"\",style=filled,fillcolor=lightgrey,shape=circle,width=.07,height=.07]");

        for (Node child : n.children.values())
            printInternalNodes(child, out);
    }

    String edgeString(Node n) {
    	String s = new String();
    	int length = n.len > 0 ? n.len : m_seq.size() - n.start;
    	for (int i = 0; i < length; ++i) {
    		s += (char)m_seq.objectAt(n.start + i);
    	}
        return s;
    }

    void printEdges(Node n, PrintWriter out) {
        for (Node child : n.children.values()) {
            out.println("\tnode"+n.id+" -> node"+child.id+" [label=\""+edgeString(child)+"\",weight=3]");
            printEdges(child, out);
        }
    }

    void printSLinks(Node n, PrintWriter out) {
        if (n.suffixLink != null)
            out.println("\tnode"+n.id+" -> node"+n.suffixLink.id+" [label=\"\",weight=1,style=dotted]");

        for (Node child : n.children.values())
            printSLinks(child, out);
    }
}
