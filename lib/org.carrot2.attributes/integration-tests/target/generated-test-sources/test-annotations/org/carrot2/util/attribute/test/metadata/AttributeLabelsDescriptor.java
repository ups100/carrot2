

// APT-generated file.

package org.carrot2.util.attribute.test.metadata;

//Imported for JavaDoc references mostly.
import org.carrot2.util.attribute.*;

import java.util.*;
import javax.annotation.*;

/**
 * Metadata and attributes of the {@link org.carrot2.util.attribute.test.metadata.AttributeLabels} component. You can use 
 * this descriptor to obtain metadata, such as human readable name and description, about the component 
 * as a whole as well as about its attributes. Using the {@link #attributeBuilder(Map)}
 * you can obtain a builder for type-safe generation of the attribute maps. Please see the
 * <a href="{@docRoot}/overview-summary.html#setting-attributes">main overview</a> for a complete code example. 
 */
@Generated("Generated from org.carrot2.util.attribute.test.metadata.AttributeLabels")
public final class AttributeLabelsDescriptor implements IBindableDescriptor
{
    /**
     * The component class for which this descriptor was generated. 
     */
    public final String bindableClassName = "org.carrot2.util.attribute.test.metadata.AttributeLabels";

    /**
     * Attribute prefix used by the component.
     */
    public final String prefix = "";

    /**
     * A one sentence summary of the component. It could be presented as a header of the tool
     * tip of the corresponding UI component.
     */
    public final String title = "";
    
    /**
     * A short label for the component. It can be presented as a label of the
     * corresponding UI component.
     */
    public final String label = "";

    /**
     * A longer, possibly multi sentence, description of the component. It could be presented
     * as a body of the tool tip of the corresponding UI component.
     */
    public final String description = "";

    /**
     * Attributes of the component. Note that only statically reachable fields are included.
     * Additional attributes may be available at run time. 
     */
    public final static Attributes attributes; 

    /**
     * Attributes declared directly by the component.
     */
    private final static Set<AttributeInfo> ownAttributes;

    /**
     * Attributes declared by the component or its superclasses.
     */
    private final static Set<AttributeInfo> allAttributes;

    /**
     * Attributes declared by the component or its superclasses, lookup dictionary 
     * by attribute key.
     */
    private final static Map<String, AttributeInfo> allAttributesByKey;

    /**
     * Attributes declared by the component or its superclasses, lookup dictionary by 
     * attribute's field name.
     */
    private final static Map<String, AttributeInfo> allAttributesByFieldName;

    /**
     * Static initializer for internal collections.
     */
    static
    {
        attributes = new Attributes();

        final Set<AttributeInfo> ownAttrs = new HashSet<AttributeInfo>();
        ownAttrs.add(attributes.singleWordLabel);
        ownAttrs.add(attributes.multiWordLabel);
        ownAttrs.add(attributes.multiSentenceLabel);
        ownAttrs.add(attributes.labelWithComment);

        final Set<AttributeInfo> allAttrs = new HashSet<AttributeInfo>();
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeLabelsDescriptor.attributes.singleWordLabel);
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeLabelsDescriptor.attributes.multiWordLabel);
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeLabelsDescriptor.attributes.multiSentenceLabel);
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeLabelsDescriptor.attributes.labelWithComment);

        allAttributes = Collections.unmodifiableSet(allAttrs);
        ownAttributes = Collections.unmodifiableSet(ownAttrs);
        
        final Map<String, AttributeInfo> allAttrsByKey = new HashMap<String, AttributeInfo>();
        final Map<String, AttributeInfo> allAttrsByFieldName = new HashMap<String, AttributeInfo>();
        for (AttributeInfo ai : allAttrs)
        {
            allAttrsByKey.put(ai.key, ai);
            allAttrsByFieldName.put(ai.fieldName, ai);
        }

        allAttributesByKey = Collections.unmodifiableMap(allAttrsByKey);
        allAttributesByFieldName = Collections.unmodifiableMap(allAttrsByFieldName);
    }

    
    /* Attribute keys. */

    /**
     * Constants for all attribute keys of the {@link org.carrot2.util.attribute.test.metadata.AttributeLabels} component.
     */
    public static class Keys 
    {
        protected Keys() {} 

        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeLabels#singleWordLabel}. */
        public static final String SINGLE_WORD_LABEL = "org.carrot2.util.attribute.test.metadata.AttributeLabels.singleWordLabel";
        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeLabels#multiWordLabel}. */
        public static final String MULTI_WORD_LABEL = "org.carrot2.util.attribute.test.metadata.AttributeLabels.multiWordLabel";
        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeLabels#multiSentenceLabel}. */
        public static final String MULTI_SENTENCE_LABEL = "org.carrot2.util.attribute.test.metadata.AttributeLabels.multiSentenceLabel";
        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeLabels#labelWithComment}. */
        public static final String LABEL_WITH_COMMENT = "org.carrot2.util.attribute.test.metadata.AttributeLabels.labelWithComment";
    }


    /* Attribute descriptors. */

    /**
     * All attributes of the {@link org.carrot2.util.attribute.test.metadata.AttributeLabels} component.
     */
    public static final class Attributes
    {
        private Attributes() { /* No public instances. */ }

        /**
         *          */
        public final AttributeInfo singleWordLabel = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeLabels.singleWordLabel",
                "org.carrot2.util.attribute.test.metadata.AttributeLabels",
                "singleWordLabel",
                null,
                "word",
                null,
                null,
                null,
                null,
                null
            );

        /**
         *          */
        public final AttributeInfo multiWordLabel = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeLabels.multiWordLabel",
                "org.carrot2.util.attribute.test.metadata.AttributeLabels",
                "multiWordLabel",
                null,
                "multi word label",
                null,
                null,
                null,
                null,
                null
            );

        /**
         *          */
        public final AttributeInfo multiSentenceLabel = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeLabels.multiSentenceLabel",
                "org.carrot2.util.attribute.test.metadata.AttributeLabels",
                "multiSentenceLabel",
                null,
                "First label sentence. Second label sentence.",
                null,
                null,
                null,
                null,
                null
            );

        /**
         *          */
        public final AttributeInfo labelWithComment = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeLabels.labelWithComment",
                "org.carrot2.util.attribute.test.metadata.AttributeLabels",
                "labelWithComment",
                "Attribute comment. Second sentence of attribute comment.",
                "word",
                "Attribute comment",
                "Second sentence of attribute comment.",
                null,
                null,
                null
            );


    }

    /**
     * Attribute map builder for the  {@link org.carrot2.util.attribute.test.metadata.AttributeLabels} component. You can use this
     * builder as a type-safe alternative to populating the attribute map using attribute keys.
     */
    public static class AttributeBuilder 
    {
        /** The attribute map populated by this builder. */
        public final Map<String, Object> map;

        /**
         * Creates a builder backed by the provided map.
         */
        protected AttributeBuilder(Map<String, Object> map)
        {
            
            this.map = map;
        }


        
        
        /**
         * 
         * 
         * @see org.carrot2.util.attribute.test.metadata.AttributeLabels#singleWordLabel 
         */
        public AttributeBuilder singleWordLabel(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeLabels.singleWordLabel", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * 
         * 
         * @see org.carrot2.util.attribute.test.metadata.AttributeLabels#multiWordLabel 
         */
        public AttributeBuilder multiWordLabel(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeLabels.multiWordLabel", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * 
         * 
         * @see org.carrot2.util.attribute.test.metadata.AttributeLabels#multiSentenceLabel 
         */
        public AttributeBuilder multiSentenceLabel(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeLabels.multiSentenceLabel", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * Attribute comment. Second sentence of attribute comment.
         * 
         * @see org.carrot2.util.attribute.test.metadata.AttributeLabels#labelWithComment 
         */
        public AttributeBuilder labelWithComment(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeLabels.labelWithComment", value);
            return this;
        }
        
        
        
        
        
    }

    /**
     * Creates an attribute map builder for the component. You can use this
     * builder as a type-safe alternative to populating the attribute map using attribute keys.
     * 
     * @param attributeValues An existing map which should be used to collect attribute values. 
     *        Attribute values set by this builder will be added to the provided map, overwriting
     *        previously defined mappings, if any.
     */
    public static AttributeBuilder attributeBuilder(Map<String, Object> attributeValues)
    {
        return new AttributeBuilder(attributeValues);
    }
    
    /* IBindableDescriptor */

    @Override 
    public String getPrefix()
    {
        return prefix;
    }

    @Override 
    public String getTitle()
    {
        return title;
    }
    
    @Override 
    public String getLabel()      
    { 
        return label;
    }
    
    @Override 
    public String getDescription() 
    { 
        return description; 
    }

    @Override 
    public Set<AttributeInfo> getOwnAttributes()
    { 
        return ownAttributes;
    }

    @Override 
    public Set<AttributeInfo> getAttributes()
    {
        return allAttributes;
    }

    @Override 
    public Map<String, AttributeInfo> getAttributesByKey()
    {
        return allAttributesByKey;
    }

    @Override 
    public Map<String, AttributeInfo> getAttributesByFieldName()
    {
        return allAttributesByFieldName;
    }
}
