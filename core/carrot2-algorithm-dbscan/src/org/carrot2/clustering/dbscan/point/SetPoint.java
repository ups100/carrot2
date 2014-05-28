package org.carrot2.clustering.dbscan.point;

import org.carrot2.clustering.dbscan.distance.DistanceFunction;

/**
 * Document model representation wrapper, used to collect calculated cluster id
 * for document
 * 
 * @param <T>
 *            Representation of point - usually double[] for vector space model
 */
public abstract class SetPoint<T> {

	/** When point isn't clustered yet */
	public static final int UNCLASSIFIED = -1;
	/** When point is noise */
	public static final int NOISE = 0;

	/** Cluster Id */
	public int clusterId = UNCLASSIFIED;
	/** Document Id */
	public int documentId = -1;
	/** Point points */
	public T points;
	/** Distance function */
	public DistanceFunction<T> distanceFunc;

	/**
	 * C-tor
	 * 
	 * @param points
	 *            Initial points
	 * @param documentId
	 *            Initial document ID
	 * @param distanceFunc
	 *            Function used to calc distance between points
	 */
	public SetPoint(T points, int documentId, DistanceFunction<T> distanceFunc) {
		this.points = points;
		this.documentId = documentId;
		this.distanceFunc = distanceFunc;
	}

	/**
	 * Calculates distance between points using {@link #distanceFunc}
	 * 
	 * @param another
	 *            Another point to calc distance with
	 * @return Calculated distance
	 */
	public double distance(SetPoint<T> another) {
		return distanceFunc.distance(this.points, another.points);
	}

	@Override
	public String toString() {
		return "[doc=" + documentId + ",cl=" + clusterId + "]";
	}

}