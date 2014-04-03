package org.carrot2.clustering.dbscan;


import java.util.List;

import org.carrot2.clustering.lingo.LingoClusteringAlgorithm;
import org.carrot2.core.Cluster;
import org.carrot2.core.Controller;
import org.carrot2.core.ControllerFactory;
import org.carrot2.core.Document;
import org.carrot2.core.IClusteringAlgorithm;
import org.carrot2.core.ProcessingComponentBase;
import org.carrot2.core.ProcessingException;
import org.carrot2.core.attribute.AttributeNames;
import org.carrot2.core.attribute.CommonAttributes;
import org.carrot2.core.attribute.Internal;
import org.carrot2.core.attribute.Processing;
import org.carrot2.util.attribute.Attribute;
import org.carrot2.util.attribute.Bindable;
import org.carrot2.util.attribute.Input;
import org.carrot2.util.attribute.Output;
import org.carrot2.util.attribute.Required;

@Bindable(prefix = "DbscanClusteringAlgorithm", inherit = CommonAttributes.class)
public class DbscanClusteringAlgorithm extends ProcessingComponentBase
		implements IClusteringAlgorithm {

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

	private final Controller controller = ControllerFactory.createSimple();
	private final Class<?> clazz = LingoClusteringAlgorithm.class;

	@Override
	public void process() throws ProcessingException {
		clusters = controller.process(documents, query, clazz).getClusters();
	}
}
