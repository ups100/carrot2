package org.carrot2.clustering.suffixtree;

import java.util.List;

import org.carrot2.clustering.lingo.LingoClusteringAlgorithm;
import org.carrot2.clustering.stc.ClusterCandidate;
import org.carrot2.core.Cluster;
import org.carrot2.core.Controller;
import org.carrot2.core.ControllerFactory;
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
import org.carrot2.util.attribute.Attribute;
import org.carrot2.util.attribute.AttributeLevel;
import org.carrot2.util.attribute.Bindable;
import org.carrot2.util.attribute.Input;
import org.carrot2.util.attribute.Level;
import org.carrot2.util.attribute.Output;
import org.carrot2.util.attribute.Required;
import org.carrot2.util.attribute.constraint.ImplementingClasses;

import com.carrotsearch.hppc.IntStack;

@Bindable(prefix = "SuffixTreeClusteringAlgorithm", inherit = CommonAttributes.class)
public class SuffixTreeClusteringAlgorithm extends ProcessingComponentBase
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

	
	private final Controller controller = ControllerFactory.createSimple();
	private final Class<?> clazz = LingoClusteringAlgorithm.class;

	/**
     * Stores the preprocessing context during {@link #process()}.
     */
    PreprocessingContext context;
	
    /* here we have token token token -1 token token token */
    public final IntStack input = new IntStack();
    
    /* here we have indexes of last token in document */
    public final IntStack docBoundaries = new IntStack();
    
	@Override
	public void process() throws ProcessingException {
		// Preprocessing of documents
		context = preprocessingPipeline.preprocess(
				documents, query, LanguageCode.ENGLISH);
		
		
		ISequence sequence = buildSequence();
		
		OurSuffixTree tree = buildSuffixTree(sequence);
		
		List<ClusterCandidate> firstCandidates = generateFirstCandidates(tree);
		
		List<ClusterCandidate> mergedCandidates = mergeCandidates(firstCandidates);
		
		finalRound(mergedCandidates);
		
		//clusters = controller.process(documents, query, clazz).getClusters();
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
                    docBoundaries.push(input.size());
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
            	input.push(tokenIndex, s, phraseLength);
            	input.push(separator--);
            }
        }
        
        return new IntegerSequence(input.buffer, 0, input.elementsCount);
	}
	
	OurSuffixTree buildSuffixTree(ISequence seq)
	{
		
	}
}
