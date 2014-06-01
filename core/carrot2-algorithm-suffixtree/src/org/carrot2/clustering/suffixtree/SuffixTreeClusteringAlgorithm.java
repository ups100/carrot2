package org.carrot2.clustering.suffixtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.carrot2.clustering.suffixtree.OurSuffixTree.Node;
import org.carrot2.core.Cluster;
import org.carrot2.core.Document;
import org.carrot2.core.IClusteringAlgorithm;
import org.carrot2.core.LanguageCode;
import org.carrot2.core.ProcessingComponentBase;
import org.carrot2.core.ProcessingException;
import org.carrot2.core.attribute.AttributeNames;
import org.carrot2.core.attribute.CommonAttributes;
import org.carrot2.core.attribute.Init;
import org.carrot2.core.attribute.Internal;
import org.carrot2.core.attribute.Processing;
import org.carrot2.text.analysis.ITokenizer;
import org.carrot2.text.analysis.TokenTypeUtils;
import org.carrot2.text.preprocessing.LabelFormatter;
import org.carrot2.text.preprocessing.PreprocessingContext;
import org.carrot2.text.preprocessing.pipeline.CompletePreprocessingPipeline;
import org.carrot2.text.preprocessing.pipeline.IPreprocessingPipeline;
import org.carrot2.util.attribute.Attribute;
import org.carrot2.util.attribute.AttributeLevel;
import org.carrot2.util.attribute.Bindable;
import org.carrot2.util.attribute.Group;
import org.carrot2.util.attribute.Input;
import org.carrot2.util.attribute.Label;
import org.carrot2.util.attribute.Level;
import org.carrot2.util.attribute.Output;
import org.carrot2.util.attribute.Required;
import org.carrot2.util.attribute.constraint.DoubleRange;
import org.carrot2.util.attribute.constraint.ImplementingClasses;

import com.carrotsearch.hppc.BitSet;
import com.carrotsearch.hppc.BitSetIterator;
import com.carrotsearch.hppc.IntStack;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Bindable(prefix = "SuffixTreeClusteringAlgorithm", inherit = CommonAttributes.class)
public class SuffixTreeClusteringAlgorithm extends ProcessingComponentBase
		implements IClusteringAlgorithm {

	/** {@link Group} name. */
	private static final String STC = "Suffix Tree params";

	@Processing
	@Input
	@Internal
	@Attribute(key = AttributeNames.QUERY, inherit = true)
	public String query = null;

	@Processing
	@Input
	@Required
	@Internal
	@Attribute(key = AttributeNames.DOCUMENTS, inherit = true)
	public List<Document> documents;

	@Processing
	@Output
	@Internal
	@Attribute(key = AttributeNames.CLUSTERS, inherit = true)
	public List<Cluster> clusters = null;

	/**
	 * Minimal number of documents to be processed
	 */
	@Processing
	@Input
	@Attribute
	@DoubleRange(min = 0)
	@Group(STC)
	@Level(AttributeLevel.BASIC)
	@Label("Minimal cardinality")
	public int minCardinality = 3;

	/**
	 * Base clusters with score lower than this will be dropped
	 */
	@Processing
	@Input
	@Attribute
	@DoubleRange(min = 0)
	@Group(STC)
	@Level(AttributeLevel.BASIC)
	@Label("Minimal score for base cluster")
	public double minBaseClusterScore = 2.0d;

	/**
	 * Maximal number of base clusters
	 */
	@Processing
	@Input
	@Attribute
	@DoubleRange(min = 0)
	@Group(STC)
	@Level(AttributeLevel.BASIC)
	@Label("Max Number of Base Clusters")
	public int maxBaseClusters = 300;

	/**
	 * Max number of finally generated clusters
	 */
	@Processing
	@Input
	@Attribute
	@DoubleRange(min = 0)
	@Group(STC)
	@Level(AttributeLevel.BASIC)
	@Label("Max Number of Clusters")
	public int maxClusters = 20;

	/**
	 * Max number of words in label
	 */
	@Processing
	@Input
	@Attribute
	@DoubleRange(min = 0)
	@Group(STC)
	@Level(AttributeLevel.BASIC)
	@Label("Max label length")
	public int maxLabelLength = 5;

	/**
	 * Max frequency of meaningful word
	 */
	@Processing
	@Input
	@Attribute
	@DoubleRange(min = 0)
	@Group(STC)
	@Level(AttributeLevel.BASIC)
	@Label("Max word")
	public double maxWordFrequency = 0.8d;


	/**
	 * Common preprocessing tasks handler.
	 */
	@Init
	@Input
	@Attribute
	@Internal
	@ImplementingClasses(classes = {}, strict = false)
	@Level(AttributeLevel.ADVANCED)
	public IPreprocessingPipeline preprocessingPipeline = new CompletePreprocessingPipeline();

	static private class ClusterCandidate {
		double score;
		BitSet documents;
		List<Path> paths;

		ClusterCandidate(Path p, BitSet doc, double score)
		{
			this.score = score;
			this.documents = doc;
			this.paths = new ArrayList<Path>();
			this.paths.add(p);
		}
		
		public ClusterCandidate(List<Path> paths, BitSet documents, double score) {
			this.score = score;
			this.documents = documents;
			this.paths = paths;
		}



		static public ClusterCandidate merge(List<ClusterCandidate> candidates) {
			ClusterCandidate first = candidates.get(0);
			BitSet bitSet = new BitSet(first.documents.length());
			double score = 0;
			double maxScore = 0;
			List<Path> paths =Lists.newArrayList();
			for (ClusterCandidate candidate : candidates) {
				bitSet.or(candidate.documents);
				score += candidate.score;
				if (candidate.score > maxScore) {
					maxScore = candidate.score;
					paths = candidate.paths;
				}
			}
			return new ClusterCandidate(paths, bitSet, score/candidates.size());
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((documents == null) ? 0 : documents.hashCode());
			result = prime * result + ((paths == null) ? 0 : paths.hashCode());
			long temp;
			temp = Double.doubleToLongBits(score);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ClusterCandidate other = (ClusterCandidate) obj;
			if (documents == null) {
				if (other.documents != null)
					return false;
			} else if (!documents.equals(other.documents))
				return false;
			if (paths == null) {
				if (other.paths != null)
					return false;
			} else if (!paths.equals(other.paths))
				return false;
			if (Double.doubleToLongBits(score) != Double
					.doubleToLongBits(other.score))
				return false;
			return true;
		}
	};
	
	class UndirectedGraph<T> {
		private Map<T, List<T>> adjacencyMap;
		
		public UndirectedGraph() {
			adjacencyMap = Maps.newHashMap();
		}
		
		public void addVertex(T vertex) {
			adjacencyMap.put(vertex, new ArrayList<T>());
		}
		
		public void addEdge(T v1, T v2) {
			adjacencyMap.get(v1).add(v2);
			adjacencyMap.get(v2).add(v1);
		}
		
		public List<List<T>> getConnectedComponents() {
			List<List<T>> result = Lists.newLinkedList();
			List<T> unvisited = Lists.newLinkedList();
			for (T vertex : adjacencyMap.keySet()) {
				unvisited.add(vertex);
			}
			
			while (!unvisited.isEmpty()) {
				Queue<T> queue = Lists.newLinkedList();
				List<T> component = Lists.newArrayList();
				queue.add(unvisited.get(0));
				component.add(unvisited.get(0));
				unvisited.remove(0);
				
				while(!queue.isEmpty()) {
					T vertex = queue.poll();
					List<T> neighbours = adjacencyMap.get(vertex);
					for(T neighbour : neighbours) {
						if (unvisited.contains(neighbour)) {
							unvisited.remove(neighbour);
							queue.add(neighbour);
							component.add(neighbour);
						}
					}
				}
				result.add(component);
			}
			
			return result;
		}
	}
	
	/**
     * Stores the preprocessing context during {@link #process()}.
     */
    PreprocessingContext context;

    OurSuffixTree tree;

    /* here we have token token token -1 token token token */
    public final IntStack m_input = new IntStack();

    /* here we have indexes of last token in document */
    public final IntStack m_docBoundaries = new IntStack();

	@Override
	public void process() throws ProcessingException {
		 clusters = new ArrayList<Cluster>();
		// Preprocessing of documents
		context = preprocessingPipeline.preprocess(
				documents, query, LanguageCode.ENGLISH);


		ISequence sequence = buildSequence();

		tree = buildSuffixTree(sequence);

		List<ClusterCandidate> firstCandidates = generateFirstCandidates(tree);
		
		firstCandidates = mergeCandidates(firstCandidates);

		postProcessing(firstCandidates);
	}

	private List<ClusterCandidate> mergeCandidates(List<ClusterCandidate> firstCandidates) {
		UndirectedGraph<ClusterCandidate> graph = new UndirectedGraph<ClusterCandidate>();
		for (ClusterCandidate candidate : firstCandidates) {
			graph.addVertex(candidate);
		}
		
		for(int i=0;i<firstCandidates.size(); i++) {
			for(int j=i+1; j<firstCandidates.size(); j++) {
				ClusterCandidate clusterI = firstCandidates.get(i);
				ClusterCandidate clusterJ = firstCandidates.get(j);
				BitSet documentsI = clusterI.documents;
				BitSet documentsJ = clusterJ.documents;
				long intersectionCount = BitSet.intersectionCount(documentsI, documentsJ);
				double pI = (double)intersectionCount/documentsI.cardinality();
				double pJ = (double)intersectionCount/documentsJ.cardinality();
				if (pI > 0.5 && pJ > 0.5) {
					graph.addEdge(clusterI, clusterJ);
				}
			}
		}
		
		List<ClusterCandidate> merged = Lists.newArrayList();
		List<List<ClusterCandidate>> connectedComponents = graph.getConnectedComponents();
		for(List<ClusterCandidate> component : connectedComponents) {
			merged.add(ClusterCandidate.merge(component));
		}
		
		/* Sort the list of generated candidates in descending using score */
		Collections.sort(merged, new Comparator<ClusterCandidate>() {

			@Override
			public int compare(ClusterCandidate o1, ClusterCandidate o2) {
				return -Double.compare(o1.score, o2.score);
			}

		});

		if (merged.size() > maxClusters) {
			merged.subList(maxClusters, merged.size()).clear();
		}

		return merged;
	}

	ISequence buildSequence()
	{
		int separator = -1;

		final int [] tokenIndex = context.allTokens.wordIndex;
        final short [] tokenType = context.allTokens.type;
        for (int i = 0; i < tokenIndex.length; i++)
        {
            /* Advance until the first real token. */
            if (tokenIndex[i] == -1)
            {
                if ((tokenType[i] & (ITokenizer.TF_SEPARATOR_DOCUMENT | ITokenizer.TF_TERMINATOR)) != 0)
                {
                    m_docBoundaries.push(m_input.size());
                }
                continue;
            }

            /* We have the first token. Advance until non-token. */
            final int s = i;

            while (tokenIndex[i + 1] != -1) i++;
            final int phraseLength = 1 + i - s;
            if (phraseLength >= 1)
            {
                /* We have a phrase. */
            	m_input.push(tokenIndex, s, phraseLength);
            	m_input.push(separator--);
            }
        }

       return new IntegerSequence(m_input.buffer, 0, m_input.elementsCount);
	}

	OurSuffixTree buildSuffixTree(ISequence seq)
	{
		OurSuffixTree tree = new OurSuffixTree(seq, m_docBoundaries.buffer);
		tree.build();
		return tree;
	}

	private  static class Path {
		int start;
		int lastStart;
		int totalLen;
		Path(int start, int lastStart, int totalLen) {
			this.start = start;
			this.lastStart = lastStart;
			this.totalLen = totalLen;
		}
	}

	List<ClusterCandidate> generateFirstCandidates(OurSuffixTree tree)
	{
		final List<ClusterCandidate> candidates = new ArrayList<ClusterCandidate>();
		final OurSuffixTree treePass = tree;

		/* iterate through the tree and select candidates for further processing */
		tree.iterateThroughtTree(tree.new Visitor(minCardinality) {

			@Override
			public void visit(Node n, BitSet documents, int lenBefore) {
				Path currentPath = new Path(n.start - lenBefore,
						n.start, lenBefore + n.len);
				if (!isPathAcceptable(currentPath, treePass.getSequence())) {
					return;
				}

				int effectiveLen = countEffectiveLen(currentPath, treePass.getSequence());
				if (effectiveLen == 0) {
					return;
				}

				double score = generateClusterScore(effectiveLen,
						(int) documents.cardinality());

				if (score >= minBaseClusterScore) {
					candidates.add(new ClusterCandidate(currentPath,
						(BitSet)documents.clone(), score));
				}
			}
		});

		/* Sort the list of generated candidates in descending using score */
		Collections.sort(candidates, new Comparator<ClusterCandidate>() {

			@Override
			public int compare(ClusterCandidate o1, ClusterCandidate o2) {
				return -Double.compare(o1.score, o2.score);
			}

		});

		if (candidates.size() > maxBaseClusters) {
			candidates.subList(maxBaseClusters, candidates.size()).clear();
		}
		return candidates;
	}

	boolean isPathAcceptable(Path p, ISequence seq)
	{
		short [] tokenTypes = context.allWords.type;

		// Ignore nodes that start with a stop word.
        if (seq.objectAt(p.start) < 0 || seq.objectAt(p.start) >= tokenTypes.length ||
        		TokenTypeUtils.isCommon(tokenTypes[seq.objectAt(p.start)]))
        {
            return false;
        }

        int start = p.lastStart;
        int end = p.start + p.totalLen - 1;
        int orginalEnd = end;
        /* Cut of trailing not meaningful tokens */
        while (start <= end && (seq.objectAt(end) < 0 || seq.objectAt(end) >= tokenTypes.length
        		|| TokenTypeUtils.isCommon(tokenTypes[seq.objectAt(end)]))) {
        	--end;
        }

        if (start < end) {
        	/* we have only common words in this branch */
        	return false;
        } else if (end < orginalEnd) {
        	/* we have trailing common words so let's remove them */
        	p.totalLen = end - p.start + 1;
        }

        if (p.totalLen > maxLabelLength) {
        	return false;
        }

        return true;
	}

	/*
	 * We count only meaningfull words, common words and words which are common in
	 * given documents are ignored.
	 */
	int countEffectiveLen(Path p, ISequence seq)
	{
		short [] tokenTypes = context.allWords.type;
		int upperLimit = (int) (maxWordFrequency * documents.size());

		int effectiveLen = 0;
		for (int i = 0; i < p.totalLen; ++i) {
			int termInd = seq.objectAt(p.start + i);
			if (termInd < 0 || termInd > tokenTypes.length || TokenTypeUtils.isCommon(tokenTypes[termInd])) {
				continue;
			}

			int docCount = context.allWords.tfByDocument[termInd].length / 2;
			if (docCount > upperLimit) {
				continue;
			}
			++effectiveLen;
		}

		return effectiveLen;
	}

	/* Determine the score */
	double generateClusterScore(int len, int docCount)
	{
		int optimal = (int) (((double) maxLabelLength)/2 + 0.5);
		int diff = len - optimal;
		double factor = Math.exp(-Math.abs(diff)*Math.abs(diff)/2);

		return docCount*factor;
	}

	/*
	 * copied from STC
	 */
	/////////////////////////////////////////////////////////////////
    private void postProcessing(List<ClusterCandidate> clusters)
    {
        // Adapt to Carrot2 classes, counting used documents on the way.
        final BitSet all = new BitSet(documents.size());
        final ArrayList<Document> docs = Lists.newArrayListWithCapacity(documents.size());
        final ArrayList<String> phrases = Lists.newArrayListWithCapacity(3);
        for (ClusterCandidate c : clusters)
        {
            final Cluster c2 = new Cluster();
            c2.addPhrases(collectPhrases(phrases, c));
            c2.addDocuments(collectDocuments(docs, c.documents));
            c2.setScore((double) c.score);
            this.clusters.add(c2);

            all.or(c.documents);
            docs.clear();
            phrases.clear();
        }

        Collections.sort(this.clusters,
            Cluster.byReversedWeightedScoreAndSizeComparator(0.5));

        Cluster.appendOtherTopics(this.documents, this.clusters);
    }

    /**
     * Collect phrases from a cluster.
     */
    private List<String> collectPhrases(List<String> l, ClusterCandidate c)
    {
        assert l != null;
        for (Path p : c.paths)
        {
            l.add(buildLabel(p, tree.getSequence()));
        }
        return l;
    }

    /**
     * Collect documents from a bitset.
     */
    private List<Document> collectDocuments(List<Document> l, BitSet bitset)
    {
        if (l == null)
        {
            l = Lists.newArrayListWithCapacity((int) bitset.cardinality());
        }

        final BitSetIterator i = bitset.iterator();
        for (int d = i.nextSetBit(); d >= 0 && d < documents.size(); d = i.nextSetBit())
        {
            l.add(documents.get(d));
        }
        return l;
    }

/////////////////////////////////////////////////////////////////

    private String buildLabel(Path p, ISequence seq)
    {
        // Count the number of terms first.
        int termsCount = p.totalLen;

        // Extract terms info for the phrase and construct the label.
        final boolean [] stopwords = new boolean[termsCount];
        final char [][] images = new char [termsCount][];
        final short [] tokenTypes = context.allWords.type;

        for (int i = 0; i < termsCount; ++i) {
        	int termIndex = seq.objectAt(i + p.start);
        	if (termIndex < 0)
        			continue;
        	images[i] = context.allWords.image[termIndex];
        	stopwords[i] = TokenTypeUtils.isCommon(tokenTypes[termIndex]);
        }

        return LabelFormatter.format(images, stopwords,
            context.language.getLanguageCode().usesSpaceDelimiters());
    }
}
