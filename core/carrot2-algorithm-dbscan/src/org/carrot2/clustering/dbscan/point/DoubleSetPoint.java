package org.carrot2.clustering.dbscan.point;

import org.carrot2.clustering.dbscan.distance.DistanceFunction;

/**
 * Model of document as array of double values (from termDocumentMatrix columns)
 */
public class DoubleSetPoint extends SetPoint<double[]> {

	/**
	 * {@inheritDoc}
	 */
	public DoubleSetPoint(double[] points, int documentId,
			DistanceFunction<double[]> distanceFunc) {
		super(points, documentId, distanceFunc);
	}

}