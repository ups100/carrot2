package org.carrot2.clustering.dbscan.distance;

/**
 * Impl. of Euclidean function for double[] points
 */
public class EuclideanFunction implements DistanceFunction<double[]> {

	@Override
	public double distance(double[] first, double[] second) {
		if (first.length != second.length)
			throw new IllegalArgumentException();

		double ret = 0;

		for (int i = 0; i < first.length; ++i)
			ret += Math.pow(first[i] - second[i], 2.0);

		return Math.sqrt(ret);
	}

}