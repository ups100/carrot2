package org.carrot2.clustering.suffixtree;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SuffixTreeTests {
	public static void main(String[] args) {
		CharacterSequence seq = new CharacterSequence("abcabxabcd$");
		int[] bounds = new int[5];
		bounds[0] = 6;
		bounds[1] = 13;
		OurSuffixTree stree = new OurSuffixTree(seq, bounds);
		stree.build();
		printNode(stree.m_root, "", seq);
		//System.out.println("works");
		try {
			PrintWriter out = new PrintWriter(new FileWriter("moj.dot"));
			stree.printTree(out);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void printNode(OurSuffixTree.Node n, String tabs, ISequence seq) {
		for(OurSuffixTree.Node child : n.children.values()) {
			System.out.print(tabs);
			printBranch(child.start, child.len, seq);
			System.out.print(" ID: " + child.id + " GID: " + child.docId);
			System.out.print('\n');
			if (child.suffixLink != null) {
				System.out.print(tabs+ "Sufix: ");
				printBranch(child.suffixLink.start, child.suffixLink.len, seq);
				System.out.print('\n');
			}
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

