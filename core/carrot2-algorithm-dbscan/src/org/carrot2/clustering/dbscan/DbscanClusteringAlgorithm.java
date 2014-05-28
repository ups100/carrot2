package org.carrot2.clustering.dbscan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.mahout.math.matrix.DoubleMatrix2D;
import org.carrot2.clustering.dbscan.distance.CosinusFunction;
import org.carrot2.clustering.dbscan.distance.DistanceFunction;
import org.carrot2.clustering.dbscan.distance.EuclideanFunction;
import org.carrot2.clustering.dbscan.point.DoubleSetPoint;
import org.carrot2.clustering.dbscan.point.SetPoint;
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
import org.carrot2.text.preprocessing.PreprocessingContext;
import org.carrot2.text.preprocessing.pipeline.CompletePreprocessingPipeline;
import org.carrot2.text.preprocessing.pipeline.IPreprocessingPipeline;
import org.carrot2.text.vsm.TermDocumentMatrixBuilder;
import org.carrot2.text.vsm.TermDocumentMatrixReducer;
import org.carrot2.text.vsm.VectorSpaceModelContext;
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
import org.carrot2.util.attribute.constraint.IntRange;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@SuppressWarnings("deprecation")
@Bindable(prefix = "DbscanClusteringAlgorithm", inherit = CommonAttributes.class)
public class DbscanClusteringAlgorithm extends ProcessingComponentBase
		implements IClusteringAlgorithm {

	/** {@link Group} name. */
	private static final String DBSCAN = "DBSCAN";

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
	 * Function which is used when calculating distance between documents.<br />
	 * Possible functions are {@link EuclideanFunction} and
	 * {@link CosinusFunction}
	 */
	@SuppressWarnings("rawtypes")
	@Input
	@Processing
	@Attribute
	@Required
	@ImplementingClasses(classes = { EuclideanFunction.class,
			CosinusFunction.class }, strict = false)
	@Label("Distance function")
	@Level(AttributeLevel.ADVANCED)
	@Group(DBSCAN)
	public DistanceFunction distanceFunction = new EuclideanFunction();

	/**
	 * Whether determine {@link #epsAttribute} and {@link #minPtsAttribute}
	 * automatically.<br />
	 * 
	 * <strong>It's not fully implemented yet due to necessary of user
	 * interaction</strong>
	 */
	@Processing
	@Input
	@Attribute
	@Group(DBSCAN)
	@Level(AttributeLevel.BASIC)
	@Label("Determine algorithm attributes")
	public boolean determineAlgorithmAttributes = false;

	/**
	 * Maximum distance between points to make them in same cluster. Used when
	 * {@link EuclideanFunction} is set
	 */
	@Processing
	@Input
	@Attribute
	@DoubleRange(min = 0)
	@Group(DBSCAN)
	@Level(AttributeLevel.BASIC)
	@Label("Eps")
	public double epsAttribute = 13.0;

	/**
	 * Threshold used when distance function is set to {@link CosinusFunction}
	 */
	@Processing
	@Input
	@Attribute
	@DoubleRange(min = 0, max = 1)
	@Group(DBSCAN)
	@Level(AttributeLevel.BASIC)
	@Label("Eps cosinus threshold")
	public double epsThresholdAttribute = 0.65;

	/**
	 * Minimum points in region (neighborhood) to classify them as cluster
	 */
	@Processing
	@Input
	@Attribute
	@IntRange(min = 0)
	@Group(DBSCAN)
	@Level(AttributeLevel.BASIC)
	@Label("MinPts")
	public int minPtsAttribute = 2;

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

	/**
	 * Term-document matrix builder for the algorithm, contains bindable
	 * attributes.
	 */
	public final TermDocumentMatrixBuilder matrixBuilder = new TermDocumentMatrixBuilder();

	/**
	 * Term-document matrix reducer for the algorithm, contains bindable
	 * attributes.
	 */
	public final TermDocumentMatrixReducer matrixReducer = new TermDocumentMatrixReducer();

	@Override
	public void process() throws ProcessingException {
		// Preprocessing of documents
		final PreprocessingContext pc = preprocessingPipeline.preprocess(
				documents, null, LanguageCode.ENGLISH);

		final VectorSpaceModelContext vsmContext = new VectorSpaceModelContext(
				pc);
		// final ReducedVectorSpaceModelContext reducedVsmContext = new
		// ReducedVectorSpaceModelContext(
		// vsmContext);

		matrixBuilder.buildTermDocumentMatrix(vsmContext);
		// matrixBuilder.buildTermPhraseMatrix(vsmContext);
		// matrixReducer.reduce(reducedVsmContext, 5);

		// printTermMatrixWithStem(vsmContext);

		List<DoubleSetPoint> setOfPoints = prepareSetOfPoints(vsmContext.termDocumentMatrix);

		if (determineAlgorithmAttributes == true) {
			calculateParameters(setOfPoints);
		}

		double epsValue = epsAttribute;
		if (distanceFunction instanceof CosinusFunction) {
			epsValue = epsThresholdAttribute;
		}

		dbscan(setOfPoints, epsValue, minPtsAttribute);

		// Put into clusters
		Map<Integer, Cluster> clusterMap = new HashMap<Integer, Cluster>();
		Map<Integer, List<Integer>> documentIdsMap = Maps.newHashMap();
		for (DoubleSetPoint spp : setOfPoints) {
			// If no cluster for clusterId, then create one
			if (clusterMap.get(spp.clusterId) == null) {
				Cluster cluster = null;
				if (spp.clusterId == SetPoint.NOISE) {
					String label = Cluster.OTHER_TOPICS_LABEL;
					cluster = new Cluster(label);
				} else {
					cluster = new Cluster();
				}

				clusterMap.put(spp.clusterId, cluster);
			}

			if (!documentIdsMap.containsKey(spp.clusterId)) {
				documentIdsMap.put(spp.clusterId, new ArrayList<Integer>());
			}
			documentIdsMap.get(spp.clusterId).add(spp.documentId);

			Document document = documents.get(spp.documentId);
			clusterMap.get(spp.clusterId).addDocument(document);
		}

		for (Integer clusterId : clusterMap.keySet()) {
			Cluster cluster = clusterMap.get(clusterId);
			List<String> phrases = getPhrases(documentIdsMap.get(clusterId),
					vsmContext);
			cluster.addPhrases(phrases);
		}

		clusters = Lists.newArrayList();
		clusters.addAll(clusterMap.values());
	}

	/**
	 * Finds most frequent stems in all documents which belong to cluster, and
	 * returns most frequent original words connected to stem.
	 * 
	 * @param documentIds
	 * @param vsmContext
	 * @return List of labels
	 */
	private List<String> getPhrases(List<Integer> documentIds,
			VectorSpaceModelContext vsmContext) {
		int[][] stemTf = vsmContext.preprocessingContext.allStems.tfByDocument;

		class Entry implements Comparable<Entry> {
			public Integer stemIdx;
			public Integer count;

			public Entry(Integer stemIdx, Integer count) {
				super();
				this.stemIdx = stemIdx;
				this.count = count;
			}

			@Override
			public int compareTo(Entry o) {
				return -count.compareTo(o.count);
			}
		}

		Map<Integer, Entry> stemClusterTf = Maps.newHashMap();
		for (int stem = 0; stem < stemTf.length; stem++) {
			for (int i = 0; i < stemTf[stem].length / 2; i++) {
				if (!documentIds.contains(stemTf[stem][2 * i])) {
					continue;
				}
				if (!stemClusterTf.containsKey(stem)) {
					stemClusterTf.put(stem, new Entry(stem, 0));
				}
				int count = stemClusterTf.get(stem).count
						+ stemTf[stem][2 * i + 1];
				stemClusterTf.put(stem, new Entry(stem, count));
			}
		}

		List<Entry> list = Lists.newArrayList(stemClusterTf.values());
		Collections.sort(list);

		List<String> result = Lists.newArrayList();
		int n = 3, i = 0, count = 0;
		while (count < n && i < list.size()) {
			int wordIdx = vsmContext.preprocessingContext.allStems.mostFrequentOriginalWordIndex[list
					.get(i).stemIdx];
			short flag = vsmContext.preprocessingContext.allWords.type[wordIdx];
			if ((flag & (ITokenizer.TF_COMMON_WORD | ITokenizer.TF_QUERY_WORD | ITokenizer.TT_NUMERIC)) == 0) {
				String stem = String
						.valueOf(vsmContext.preprocessingContext.allWords.image[wordIdx]);
				// Capitalize first letter
				stem = Character.toUpperCase(stem.charAt(0))
						+ stem.substring(1);
				result.add(stem);
				count++;
			}
			i++;
		}

		return result;
	}

	/**
	 * Determine DBSCAN parameters based on simply heuristic
	 * 
	 * @param setOfPoints
	 *            Entire points
	 */
	private void calculateParameters(List<DoubleSetPoint> setOfPoints) {
		/**
		 * List of distances:
		 * 
		 * <pre>
		 * [
		 * 	A->A, A->B, A->C, .., A->Z
		 *  B->A, B->B, B->C, .., B->Z
		 *  ..
		 *  Z->A, Z->B, Z->C, .., Z->Z
		 * ]
		 * </pre>
		 * 
		 * Then sorted by distances
		 */
		List<List<Double>> kDist = Lists.newArrayList();

		for (DoubleSetPoint a : setOfPoints) {
			List<Double> distances = Lists.newArrayList();
			for (DoubleSetPoint b : setOfPoints) {
				distances.add(a.distance(b));
			}

			Collections.sort(distances);
			kDist.add(distances);
		}

		// 1st neighbor k = 1
		// nth neighbor k = n
		for (int k = 1; k < 5; ++k) {
			List<Double> kDim = Lists.newArrayList();

			for (List<Double> distances : kDist) {
				kDim.add(distances.get(k));
			}

			Collections.sort(kDim);
			Collections.reverse(kDim);
		}

		// TODO proper impl. has to be done, now at the bottom is hardcoded
		// Hardcoded
		try {
			int k = 2;
			int p = 3;
			List<Double> kDim = Lists.newArrayList();

			for (List<Double> distances : kDist) {
				kDim.add(distances.get(k));
			}

			Collections.sort(kDim);
			Collections.reverse(kDim);

			epsAttribute = kDim.get(p);
			epsThresholdAttribute = epsAttribute;
			minPtsAttribute = k;
		} catch (Exception e) {
			// When out of bounds..
			epsAttribute = 1;
			epsThresholdAttribute = 0.5;
			minPtsAttribute = 1;
		}
	}

	/**
	 * Print matrix where rows are stems, columns are documents -> at the end of
	 * row print stem
	 * 
	 * @param vsmContext
	 */
	@SuppressWarnings("unused")
	private void printTermMatrixWithStem(VectorSpaceModelContext vsmContext) {
		double[][] tdm = vsmContext.termDocumentMatrix.toArray();
		for (int y = 0; y < tdm.length; ++y) {
			for (int x = 0; x < tdm[0].length; ++x)
				System.out.print(String.format("%.4f\t", tdm[y][x]));
			System.out
					.println(vsmContext.preprocessingContext.allStems.image[vsmContext.stemToRowIndex.keys[y]]);
		}
	}

	/**
	 * Entry point to DBSCAN clustering algorithm
	 * 
	 * @param setOfPoints
	 *            Entire set of points
	 * @param eps
	 *            Maximum distance between points to make them in same cluster
	 * @param minPts
	 *            Minimum points in region (neighborhood) to classify them as
	 *            cluster
	 */
	private <T> void dbscan(List<? extends SetPoint<T>> setOfPoints,
			double eps, int minPts) {
		int clusterId = SetPoint.NOISE + 1;

		for (int i = 0; i < setOfPoints.size(); ++i) {
			SetPoint<T> point = setOfPoints.get(i);

			if (point.clusterId == SetPoint.UNCLASSIFIED) {
				if (expandCluster(setOfPoints, point, clusterId, eps, minPts) == true) {
					clusterId += 1;
				}
			}
		}
	}

	/**
	 * Expand cluster if there is minimum amount of points in region of given
	 * center point
	 * 
	 * @param setOfPoints
	 *            Entire set of points
	 * @param point
	 *            Current center point
	 * @param clId
	 *            Next cluster Id
	 * @param eps
	 *            Maximum distance between points to make them in same cluster
	 * @param minPts
	 *            Minimum points in region (neighborhood) to classify them as
	 *            cluster
	 * @return
	 */
	private <T> boolean expandCluster(List<? extends SetPoint<T>> setOfPoints,
			SetPoint<T> point, int clId, double eps, int minPts) {
		List<SetPoint<T>> seeds = regionQuery(setOfPoints, point, eps);

		if (seeds.size() < minPts) { // no core point
			point.clusterId = SetPoint.NOISE;
			return false;
		} else { // all points in seeds are density-reachable from point
			for (SetPoint<T> sp : seeds) {
				sp.clusterId = clId;
			}
			seeds.remove(point);

			while (seeds.isEmpty() == false) {
				SetPoint<T> currentP = seeds.get(0);
				List<SetPoint<T>> result = regionQuery(setOfPoints, currentP,
						eps);

				if (result.size() >= minPts) {
					for (int i = 0; i < result.size(); ++i) {
						SetPoint<T> resultP = result.get(i);

						if (resultP.clusterId == SetPoint.UNCLASSIFIED
								|| resultP.clusterId == SetPoint.NOISE) {
							if (resultP.clusterId == SetPoint.UNCLASSIFIED) {
								seeds.add(resultP);
							}
							resultP.clusterId = clId;
						}
					}
				}
				seeds.remove(currentP);
			}
			return true;
		}
	}

	/**
	 * Finds {@link SetPoint} in given eps range (neighborhood), including
	 * itself
	 * 
	 * <pre>
	 * NEps(p) = {q E D | dist(p,q) <= Eps}
	 * </pre>
	 * 
	 * @param setOfPoints
	 *            Entire set of points
	 * @param point
	 *            Center point
	 * @param eps
	 *            Maximum distance between points to it add to region
	 * @return New set of points containing center point and points in distance
	 *         between them and center point which is less than eps value
	 */
	private <T> List<SetPoint<T>> regionQuery(
			List<? extends SetPoint<T>> setOfPoints, SetPoint<T> point,
			double eps) {
		List<SetPoint<T>> nEps = Lists.newArrayList();

		for (SetPoint<T> sp : setOfPoints) {
			if (point.distance(sp) < eps) {
				nEps.add(sp);
			}
		}

		return nEps;
	}

	/**
	 * Prepare set of {@link DoubleSetPoint} points from given matrix, where
	 * each point represents document - columns data
	 * 
	 * @param tdm
	 *            Generated term document matrix
	 * @return List of points
	 */
	@SuppressWarnings("unchecked")
	private List<DoubleSetPoint> prepareSetOfPoints(DoubleMatrix2D tdm) {
		List<DoubleSetPoint> set = Lists.newArrayList();
		// Transpose matrix to have documents as rows
		double[][] ttdm = tdm.viewDice().toArray();

		for (int i = 0; i < ttdm.length; ++i) {
			set.add(new DoubleSetPoint(ttdm[i], i, distanceFunction));
		}

		return set;
	}

}
