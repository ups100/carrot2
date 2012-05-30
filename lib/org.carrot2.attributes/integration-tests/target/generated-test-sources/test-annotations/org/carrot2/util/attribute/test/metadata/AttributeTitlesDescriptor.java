

// APT-generated file.

package org.carrot2.util.attribute.test.metadata;

//Imported for JavaDoc references mostly.
import org.carrot2.util.attribute.*;

import java.util.*;
import javax.annotation.*;

/**
 * Metadata and attributes of the {@link org.carrot2.util.attribute.test.metadata.AttributeTitles} component. You can use 
 * this descriptor to obtain metadata, such as human readable name and description, about the component 
 * as a whole as well as about its attributes. Using the {@link #attributeBuilder(Map)}
 * you can obtain a builder for type-safe generation of the attribute maps. Please see the
 * <a href="{@docRoot}/overview-summary.html#setting-attributes">main overview</a> for a complete code example. 
 */
@Generated("Generated from org.carrot2.util.attribute.test.metadata.AttributeTitles")
public final class AttributeTitlesDescriptor implements IBindableDescriptor
{
    /**
     * The component class for which this descriptor was generated. 
     */
    public final String bindableClassName = "org.carrot2.util.attribute.test.metadata.AttributeTitles";

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
        ownAttrs.add(attributes.noTitle);
        ownAttrs.add(attributes.emptyTitle);
        ownAttrs.add(attributes.titleWithPeriod);
        ownAttrs.add(attributes.titleWithExtraSpace);
        ownAttrs.add(attributes.titleWithoutPeriod);
        ownAttrs.add(attributes.titleWithExclamationMark);
        ownAttrs.add(attributes.titleWithExtraPeriods);
        ownAttrs.add(attributes.titleWithLink);
        ownAttrs.add(attributes.descriptionWithLinks);
        ownAttrs.add(attributes.descriptionWithNumericEntities);
        ownAttrs.add(attributes.titleWithDescription);
        ownAttrs.add(attributes.titleWithLabel);

        final Set<AttributeInfo> allAttrs = new HashSet<AttributeInfo>();
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeTitlesDescriptor.attributes.noTitle);
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeTitlesDescriptor.attributes.emptyTitle);
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeTitlesDescriptor.attributes.titleWithPeriod);
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeTitlesDescriptor.attributes.titleWithExtraSpace);
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeTitlesDescriptor.attributes.titleWithoutPeriod);
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeTitlesDescriptor.attributes.titleWithExclamationMark);
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeTitlesDescriptor.attributes.titleWithExtraPeriods);
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeTitlesDescriptor.attributes.titleWithLink);
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeTitlesDescriptor.attributes.descriptionWithLinks);
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeTitlesDescriptor.attributes.descriptionWithNumericEntities);
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeTitlesDescriptor.attributes.titleWithDescription);
        allAttrs.add(org.carrot2.util.attribute.test.metadata.AttributeTitlesDescriptor.attributes.titleWithLabel);

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
     * Constants for all attribute keys of the {@link org.carrot2.util.attribute.test.metadata.AttributeTitles} component.
     */
    public static class Keys 
    {
        protected Keys() {} 

        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeTitles#noTitle}. */
        public static final String NO_TITLE = "org.carrot2.util.attribute.test.metadata.AttributeTitles.noTitle";
        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeTitles#emptyTitle}. */
        public static final String EMPTY_TITLE = "org.carrot2.util.attribute.test.metadata.AttributeTitles.emptyTitle";
        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeTitles#titleWithPeriod}. */
        public static final String TITLE_WITH_PERIOD = "org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithPeriod";
        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeTitles#titleWithExtraSpace}. */
        public static final String TITLE_WITH_EXTRA_SPACE = "org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithExtraSpace";
        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeTitles#titleWithoutPeriod}. */
        public static final String TITLE_WITHOUT_PERIOD = "org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithoutPeriod";
        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeTitles#titleWithExclamationMark}. */
        public static final String TITLE_WITH_EXCLAMATION_MARK = "org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithExclamationMark";
        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeTitles#titleWithExtraPeriods}. */
        public static final String TITLE_WITH_EXTRA_PERIODS = "org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithExtraPeriods";
        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeTitles#titleWithLink}. */
        public static final String TITLE_WITH_LINK = "org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithLink";
        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeTitles#descriptionWithLinks}. */
        public static final String DESCRIPTION_WITH_LINKS = "org.carrot2.util.attribute.test.metadata.AttributeTitles.descriptionWithLinks";
        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeTitles#descriptionWithNumericEntities}. */
        public static final String DESCRIPTION_WITH_NUMERIC_ENTITIES = "org.carrot2.util.attribute.test.metadata.AttributeTitles.descriptionWithNumericEntities";
        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeTitles#titleWithDescription}. */
        public static final String TITLE_WITH_DESCRIPTION = "org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithDescription";
        /** Attribute key for: {@link org.carrot2.util.attribute.test.metadata.AttributeTitles#titleWithLabel}. */
        public static final String TITLE_WITH_LABEL = "org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithLabel";
    }


    /* Attribute descriptors. */

    /**
     * All attributes of the {@link org.carrot2.util.attribute.test.metadata.AttributeTitles} component.
     */
    public static final class Attributes
    {
        private Attributes() { /* No public instances. */ }

        /**
         *          */
        public final AttributeInfo noTitle = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeTitles.noTitle",
                "org.carrot2.util.attribute.test.metadata.AttributeTitles",
                "noTitle",
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
        public final AttributeInfo emptyTitle = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeTitles.emptyTitle",
                "org.carrot2.util.attribute.test.metadata.AttributeTitles",
                "emptyTitle",
                ". Description follows.",
                "label",
                null,
                null,
                null,
                null,
                null
            );

        /**
         *          */
        public final AttributeInfo titleWithPeriod = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithPeriod",
                "org.carrot2.util.attribute.test.metadata.AttributeTitles",
                "titleWithPeriod",
                "Title with period.",
                null,
                "Title with period",
                null,
                null,
                null,
                null
            );

        /**
         *          */
        public final AttributeInfo titleWithExtraSpace = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithExtraSpace",
                "org.carrot2.util.attribute.test.metadata.AttributeTitles",
                "titleWithExtraSpace",
                "Title    with\n\n\nextra    space.",
                null,
                "Title with extra space",
                null,
                null,
                null,
                null
            );

        /**
         *          */
        public final AttributeInfo titleWithoutPeriod = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithoutPeriod",
                "org.carrot2.util.attribute.test.metadata.AttributeTitles",
                "titleWithoutPeriod",
                "Title without period",
                null,
                "Title without period",
                null,
                null,
                null,
                null
            );

        /**
         *          */
        public final AttributeInfo titleWithExclamationMark = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithExclamationMark",
                "org.carrot2.util.attribute.test.metadata.AttributeTitles",
                "titleWithExclamationMark",
                "Title with exclamation mark! and something more. Description.",
                null,
                "Title with exclamation mark! and something more",
                "Description.",
                null,
                null,
                null
            );

        /**
         *          */
        public final AttributeInfo titleWithExtraPeriods = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithExtraPeriods",
                "org.carrot2.util.attribute.test.metadata.AttributeTitles",
                "titleWithExtraPeriods",
                "Title with extra periods (e.g. www.carrot2.org). Description.",
                null,
                "Title with extra periods (e.g. www.carrot2.org)",
                "Description.",
                null,
                null,
                null
            );

        /**
         *          */
        public final AttributeInfo titleWithLink = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithLink",
                "org.carrot2.util.attribute.test.metadata.AttributeTitles",
                "titleWithLink",
                "Title with link to {@link AttributeTitles#titleWithLink}. Description.",
                null,
                "Title with link to <code>AttributeTitles.titleWithLink<\/code>",
                "Description.",
                null,
                null,
                null
            );

        /**
         *          */
        public final AttributeInfo descriptionWithLinks = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeTitles.descriptionWithLinks",
                "org.carrot2.util.attribute.test.metadata.AttributeTitles",
                "descriptionWithLinks",
                "Title. Description with {@link org.carrot2.util.attribute.test.metadata.AttributeTitles#descriptionWithLinks} and {@link String} links.",
                null,
                "Title",
                "Description with <code>org.carrot2.util.attribute.test.metadata.AttributeTitles.descriptionWithLinks<\/code> and <code>String<\/code> links.",
                null,
                null,
                null
            );

        /**
         *          */
        public final AttributeInfo descriptionWithNumericEntities = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeTitles.descriptionWithNumericEntities",
                "org.carrot2.util.attribute.test.metadata.AttributeTitles",
                "descriptionWithNumericEntities",
                "Title. Description with &#160;.",
                null,
                "Title",
                "Description with &#160;.",
                null,
                null,
                null
            );

        /**
         *          */
        public final AttributeInfo titleWithDescription = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithDescription",
                "org.carrot2.util.attribute.test.metadata.AttributeTitles",
                "titleWithDescription",
                "Title with description. Description follows.",
                null,
                "Title with description",
                "Description follows.",
                null,
                null,
                null
            );

        /**
         *          */
        public final AttributeInfo titleWithLabel = 
            new AttributeInfo(
                "org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithLabel",
                "org.carrot2.util.attribute.test.metadata.AttributeTitles",
                "titleWithLabel",
                "Title with label.",
                "label",
                "Title with label",
                null,
                null,
                null,
                null
            );


    }

    /**
     * Attribute map builder for the  {@link org.carrot2.util.attribute.test.metadata.AttributeTitles} component. You can use this
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
         * @see org.carrot2.util.attribute.test.metadata.AttributeTitles#noTitle 
         */
        public AttributeBuilder noTitle(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeTitles.noTitle", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * . Description follows.
         * 
         * @see org.carrot2.util.attribute.test.metadata.AttributeTitles#emptyTitle 
         */
        public AttributeBuilder emptyTitle(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeTitles.emptyTitle", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * Title with period.
         * 
         * @see org.carrot2.util.attribute.test.metadata.AttributeTitles#titleWithPeriod 
         */
        public AttributeBuilder titleWithPeriod(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithPeriod", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * Title    with


extra    space.
         * 
         * @see org.carrot2.util.attribute.test.metadata.AttributeTitles#titleWithExtraSpace 
         */
        public AttributeBuilder titleWithExtraSpace(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithExtraSpace", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * Title without period
         * 
         * @see org.carrot2.util.attribute.test.metadata.AttributeTitles#titleWithoutPeriod 
         */
        public AttributeBuilder titleWithoutPeriod(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithoutPeriod", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * Title with exclamation mark! and something more. Description.
         * 
         * @see org.carrot2.util.attribute.test.metadata.AttributeTitles#titleWithExclamationMark 
         */
        public AttributeBuilder titleWithExclamationMark(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithExclamationMark", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * Title with extra periods (e.g. www.carrot2.org). Description.
         * 
         * @see org.carrot2.util.attribute.test.metadata.AttributeTitles#titleWithExtraPeriods 
         */
        public AttributeBuilder titleWithExtraPeriods(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithExtraPeriods", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * Title with link to {@link AttributeTitles#titleWithLink}. Description.
         * 
         * @see org.carrot2.util.attribute.test.metadata.AttributeTitles#titleWithLink 
         */
        public AttributeBuilder titleWithLink(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithLink", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * Title. Description with {@link org.carrot2.util.attribute.test.metadata.AttributeTitles#descriptionWithLinks} and {@link String} links.
         * 
         * @see org.carrot2.util.attribute.test.metadata.AttributeTitles#descriptionWithLinks 
         */
        public AttributeBuilder descriptionWithLinks(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeTitles.descriptionWithLinks", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * Title. Description with &#160;.
         * 
         * @see org.carrot2.util.attribute.test.metadata.AttributeTitles#descriptionWithNumericEntities 
         */
        public AttributeBuilder descriptionWithNumericEntities(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeTitles.descriptionWithNumericEntities", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * Title with description. Description follows.
         * 
         * @see org.carrot2.util.attribute.test.metadata.AttributeTitles#titleWithDescription 
         */
        public AttributeBuilder titleWithDescription(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithDescription", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * Title with label.
         * 
         * @see org.carrot2.util.attribute.test.metadata.AttributeTitles#titleWithLabel 
         */
        public AttributeBuilder titleWithLabel(int value)
        {
            map.put("org.carrot2.util.attribute.test.metadata.AttributeTitles.titleWithLabel", value);
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
