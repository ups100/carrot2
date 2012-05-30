

// APT-generated file.

package org.carrot2.util.attribute.test.metadata;

//Imported for JavaDoc references mostly.
import org.carrot2.util.attribute.*;

import java.util.*;
import javax.annotation.*;

/**
 * Metadata and attributes of the {@link org.carrot2.util.attribute.test.metadata.AttributeDescriptions} component. You can use 
 * this descriptor to obtain metadata, such as human readable name and description, about the component 
 * as a whole as well as about its attributes. Using the {@link #attributeBuilder(Map)}
 * you can obtain a builder for type-safe generation of the attribute maps. Please see the
 * <a href="{@docRoot}/overview-summary.html#setting-attributes">main overview</a> for a complete code example. 
 */
@Generated("Generated from org.carrot2.util.attribute.test.metadata.AttributeDescriptions")
public final class AttributeDescriptionsDescriptor implements IBindableDescriptor
{
    /**
     * The component class for which this descriptor was generated. 
     */
    public final String bindableClassName = "org.carrot2.util.attribute.test.metadata.AttributeDescriptions";

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
        ownAttrs.add(attributes.noDescriptionNoTitle);
        ownAttrs.add(attributes.noDescription);
        ownAttrs.add(attributes.singleSentenceDescription);
        ownAttrs.add(attributes.twoSentenceDescription);
        ownAttrs.add(attributes.descriptionWithExtraSpace);

        final Set<AttributeInfo> allAttrs = new HashSet<AttributeInfo>();
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeDescriptionsDescriptor.attributes.noDescriptionNoTitle);
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeDescriptionsDescriptor.attributes.noDescription);
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeDescriptionsDescriptor.attributes.singleSentenceDescription);
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeDescriptionsDescriptor.attributes.twoSentenceDescription);
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeDescriptionsDescriptor.attributes.descriptionWithExtraSpace);

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
     * Constants for all attribute keys of the {@link org.carrot2.util.attribute.test.metadata.AttributeDescriptions} component.
     */
    public static class Keys 
    {
        protected Keys() {} 

        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeDescriptions#noDescriptionNoTitle}. */
        public static final String NO_DESCRIPTION_NO_TITLE = "org.carrot2.util.attribute.test.metadata.AttributeDescriptions.noDescriptionNoTitle";
        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeDescriptions#noDescription}. */
        public static final String NO_DESCRIPTION = "org.carrot2.util.attribute.test.metadata.AttributeDescriptions.noDescription";
        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeDescriptions#singleSentenceDescription}. */
        public static final String SINGLE_SENTENCE_DESCRIPTION = "org.carrot2.util.attribute.test.metadata.AttributeDescriptions.singleSentenceDescription";
        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeDescriptions#twoSentenceDescription}. */
        public static final String TWO_SENTENCE_DESCRIPTION = "org.carrot2.util.attribute.test.metadata.AttributeDescriptions.twoSentenceDescription";
        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeDescriptions#descriptionWithExtraSpace}. */
        public static final String DESCRIPTION_WITH_EXTRA_SPACE = "org.carrot2.util.attribute.test.metadata.AttributeDescriptions.descriptionWithExtraSpace";
    }


    /* Attribute descriptors. */

    /**
     * All attributes of the {@link org.carrot2.util.attribute.test.metadata.AttributeDescriptions} component.
     */
    public static final class Attributes
    {
        private Attributes() { /* No public instances. */ }

        /**
         *          */
        public final AttributeInfo noDescriptionNoTitle = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeDescriptions.noDescriptionNoTitle",
                "org.carrot2.util.attribute.test.metadata.AttributeDescriptions",
                "noDescriptionNoTitle",
                null,
                "label",
                null,
                null,
                null,
                null,
                null
            );

        /**
         *          */
        public final AttributeInfo noDescription = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeDescriptions.noDescription",
                "org.carrot2.util.attribute.test.metadata.AttributeDescriptions",
                "noDescription",
                "Title.",
                "label",
                "Title",
                null,
                null,
                null,
                null
            );

        /**
         *          */
        public final AttributeInfo singleSentenceDescription = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeDescriptions.singleSentenceDescription",
                "org.carrot2.util.attribute.test.metadata.AttributeDescriptions",
                "singleSentenceDescription",
                "Title. Single sentence description.",
                null,
                "Title",
                "Single sentence description.",
                null,
                null,
                null
            );

        /**
         *          */
        public final AttributeInfo twoSentenceDescription = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeDescriptions.twoSentenceDescription",
                "org.carrot2.util.attribute.test.metadata.AttributeDescriptions",
                "twoSentenceDescription",
                "Title. Description sentence 1. Description sentence 2.",
                null,
                "Title",
                "Description sentence 1. Description sentence 2.",
                null,
                null,
                null
            );

        /**
         *          */
        public final AttributeInfo descriptionWithExtraSpace = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeDescriptions.descriptionWithExtraSpace",
                "org.carrot2.util.attribute.test.metadata.AttributeDescriptions",
                "descriptionWithExtraSpace",
                "Title. Description\n\nwith     extra\nspace.",
                null,
                "Title",
                "Description with extra space.",
                null,
                null,
                null
            );


    }

    /**
     * Attribute map builder for the  {@link org.carrot2.util.attribute.test.metadata.AttributeDescriptions} component. You can use this
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
         * @see org.carrot2.util.attribute.test.metadata.AttributeDescriptions#noDescriptionNoTitle 
         */
        public AttributeBuilder noDescriptionNoTitle(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeDescriptions.noDescriptionNoTitle", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * Title.
         * 
         * @see org.carrot2.util.attribute.test.metadata.AttributeDescriptions#noDescription 
         */
        public AttributeBuilder noDescription(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeDescriptions.noDescription", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * Title. Single sentence description.
         * 
         * @see org.carrot2.util.attribute.test.metadata.AttributeDescriptions#singleSentenceDescription 
         */
        public AttributeBuilder singleSentenceDescription(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeDescriptions.singleSentenceDescription", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * Title. Description sentence 1. Description sentence 2.
         * 
         * @see org.carrot2.util.attribute.test.metadata.AttributeDescriptions#twoSentenceDescription 
         */
        public AttributeBuilder twoSentenceDescription(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeDescriptions.twoSentenceDescription", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * Title. Description

with     extra
space.
         * 
         * @see org.carrot2.util.attribute.test.metadata.AttributeDescriptions#descriptionWithExtraSpace 
         */
        public AttributeBuilder descriptionWithExtraSpace(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeDescriptions.descriptionWithExtraSpace", value);
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
