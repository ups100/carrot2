package org.carrot2.clustering.suffixtree;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

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
	Node m_previous;

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
		System.out.println(m_current + " " + newDocId);
		return newDocId;
	}

	private void handleNoTargetNode()
	{
		/* Check if there is a suffix which begins with given id */
		if (m_activePoint.currentNode.children.containsKey(m_seq.objectAt(m_current))) {
			/* current node has a child which begins with it */
			++m_reminder;

			Node target = m_activePoint.currentNode.children.get(m_seq.objectAt(m_current));
			/* check maybe we should directly jump to that state */
			if (target.len == 1) {
				m_activePoint.currentNode = target;
				m_activePoint.targetNode = null;
				m_activePoint.len =  0;
			} else {
				m_activePoint.targetNode = target;
				m_activePoint.len = 1;
			}
		} else {
			/* there is no such child, we insert new one */
			int newDocId = generateDocId();

			/* create new node */
			Node newOne = new Node(m_nodes.size() -1, m_current, -1, newDocId);
			m_nodes.add(newOne);

			m_activePoint.currentNode.children.put(m_seq.objectAt(m_current), newOne);
		}
	}

	public void handleTheSameTokens()
	{
		++m_reminder;
		++(m_activePoint.len);

		/* Didn't we get the whole sentence? */
		if (m_activePoint.len == m_activePoint.targetNode.len) {
			/* We have whole branch so let's go to next state */
			m_activePoint.currentNode = m_activePoint.targetNode;
			m_activePoint.targetNode = null;
			m_activePoint.len =  0;
		}
	}

	public void splitOutNodes(int nextToken)
	{
		int newDocId = generateDocId();

		/* remove from children of current node */
		m_activePoint.currentNode.children.remove(m_seq.objectAt(m_activePoint.targetNode.start));

		/* create new nodes in the middle */
		Node midle = new Node(m_nodes.size() -1, m_activePoint.targetNode.start, m_activePoint.len, newDocId);
		m_nodes.add(midle);

		/* Add to current node */
		m_activePoint.currentNode.children.put(m_seq.objectAt(midle.start), midle);

		/* move forward start of last target node */
		m_activePoint.targetNode.start = m_activePoint.targetNode.start + m_activePoint.len;

		/* add it as first child of new middle node */
		midle.children.put(nextToken, m_activePoint.targetNode);


		/* Create node for new sentence */
		Node newOne = new Node(m_nodes.size() -1, m_current, -1, newDocId);
		m_nodes.add(newOne);

		/* add as second child */
		midle.children.put(m_seq.objectAt(m_current), newOne);
	}

	void goToNextNode()
	{
		if (m_activePoint.currentNode.id == 0) {
			--(m_activePoint.len);
			m_activePoint.targetNode = m_activePoint.currentNode.children.get(m_seq.objectAt(m_current - m_activePoint.len));
			if (m_activePoint.targetNode == null) {
				handleNoTargetNode();
			}
		} else {
			/* Current active node is not a root */
			if (m_activePoint.currentNode.suffixLink != null) {
				/* we go to that link */
				m_activePoint.currentNode = m_activePoint.currentNode.suffixLink;

			} else {
				/* we go to root */
				m_activePoint.currentNode = m_root;
			}

			/* select edge with the same first character */
			m_activePoint.targetNode = m_activePoint.currentNode.children.get(m_seq.objectAt(m_previous.start));
			if (m_activePoint.targetNode == null) {
				handleNoTargetNode();
			}
		}
	}

	public void build()
	{
		m_root = new Node(0, 0, -1, -1);
		m_nodes = new ArrayList<Node>();
		m_nodes.add(m_root);
		m_activePoint = new ActivePoint();
		m_activePoint.currentNode = m_root;
		m_reminder = 1;

		for (m_current = 0; m_current < m_seq.size(); ++m_current) {
			/* do we insert first character of suffix ?*/
			if (m_activePoint.targetNode == null) {
				handleNoTargetNode();
			} else {
				int nextToken = m_seq.objectAt(m_activePoint.targetNode.start + m_activePoint.len);
				if (m_seq.objectAt(m_current) == nextToken) {
					/* sequences are the same */
					handleTheSameTokens();
				} else {
					/* Tokens differ so we have to split out sentences */
					splitOutNodes(nextToken);
					/* this is our middle point */
					m_previous = m_activePoint.currentNode.children.get(m_seq.objectAt(m_current - m_activePoint.len));
					/* one is done so let's decrement this */
					--m_reminder;

					goToNextNode();

					while (m_reminder > 1) {
						nextToken = m_seq.objectAt(m_activePoint.targetNode.start + m_activePoint.len);
						if (m_seq.objectAt(m_current) == nextToken) {
							break;
						} else {
							splitOutNodes(nextToken);
							/*set suffix link */
							m_previous.suffixLink = m_activePoint.currentNode.children.get(m_seq.objectAt(m_current - m_activePoint.len));
							/* move previous forward */
							m_previous = m_previous.suffixLink;
							--m_reminder;

							goToNextNode();
						}
					}
				}

			}
		}
	}


}
