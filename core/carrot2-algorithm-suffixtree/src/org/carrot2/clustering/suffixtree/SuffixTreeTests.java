package org.carrot2.clustering.suffixtree;

public class SuffixTreeTests {
	public static void main(String[] args) {
		CharacterSequence seq = new CharacterSequence("abcab#xabcd$");
		int[] bounds = new int[5];
		bounds[0] = 6;
		bounds[1] = 13;
		OurSuffixTree stree = new OurSuffixTree(seq, bounds);
		stree.build();
		printNode(stree.m_root, "", seq);
		System.out.println("works");
	}
	
	static void printNode(OurSuffixTree.Node n, String tabs, ISequence seq) {
		for(OurSuffixTree.Node child : n.children.values()) {
			System.out.print(tabs);
			printBranch(child.start, child.len, seq);
			System.out.print(" ID: " + child.id + " GID: " + child.docId);
			System.out.print('\n');
			printNode(child, tabs + '\t', seq);
		}
	}

	static void printBranch(int start, int len, ISequence seq)
	{
		len = len == -1 ? seq.size() - start : len;
		for(int i = 0 ;i < len; ++i) {
			System.out.print((char)seq.objectAt(start +i));
		}
	}
}

