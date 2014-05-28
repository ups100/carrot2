package org.carrot2.clustering.dbscan.distance;

/**
 * Impl. of Cosinus measure between double[] points
 */
public class CosinusFunction implements DistanceFunction<double[]> {

	@Override
	public double distance(double[] first, double[] second) {
		if (first.length != second.length)
			throw new IllegalArgumentException();

		double dotProduct = 0.0;
		double normA = 0.0;
		double normB = 0.0;

		for (int i = 0; i < first.length; i++) {
			dotProduct += first[i] * second[i];
			normA += Math.pow(first[i], 2);
			normB += Math.pow(second[i], 2);
		}

		return (1 - dotProduct / (Math.sqrt(normA) * Math.sqrt(normB)));
	}

}