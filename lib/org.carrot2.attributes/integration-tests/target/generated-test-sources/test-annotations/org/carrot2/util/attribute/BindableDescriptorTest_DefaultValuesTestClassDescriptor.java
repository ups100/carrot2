

// APT-generated file.

package org.carrot2.util.attribute;


import java.util.*;
import javax.annotation.*;

/**
 * Metadata and attributes of the {@link org.carrot2.util.attribute.BindableDescriptorTest.DefaultValuesTestClass} component. You can use 
 * this descriptor to obtain metadata, such as human readable name and description, about the component 
 * as a whole as well as about its attributes. Using the {@link #attributeBuilder(Map)}
 * you can obtain a builder for type-safe generation of the attribute maps. Please see the
 * <a href="{@docRoot}/overview-summary.html#setting-attributes">main overview</a> for a complete code example. 
 */
@Generated("Generated from org.carrot2.util.attribute.BindableDescriptorTest.DefaultValuesTestClass")
public final class DefaultValuesTestClassDescriptor implements IBindableDescriptor
{
    /**
     * The component class for which this descriptor was generated. 
     */
    public final String bindableClassName = "org.carrot2.util.attribute.BindableDescriptorTest.DefaultValuesTestClass";

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
        ownAttrs.add(attributes.optional);
        ownAttrs.add(attributes.required);
        ownAttrs.add(attributes.nonNull);
        ownAttrs.add(attributes.output);

        final Set<AttributeInfo> allAttrs = new HashSet<AttributeInfo>();
        allAttrs.add(org.carrot2.util.attribute.BindableDescriptorTest_DefaultValuesTestClassDescriptor.attributes.optional);
        allAttrs.add(org.carrot2.util.attribute.BindableDescriptorTest_DefaultValuesTestClassDescriptor.attributes.required);
        allAttrs.add(org.carrot2.util.attribute.BindableDescriptorTest_DefaultValuesTestClassDescriptor.attributes.nonNull);
        allAttrs.add(org.carrot2.util.attribute.BindableDescriptorTest_DefaultValuesTestClassDescriptor.attributes.output);

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
     * Constants for all attribute keys of the {@link org.carrot2.util.attribute.BindableDescriptorTest.DefaultValuesTestClass} component.
     */
    public static class Keys 
    {
        protected Keys() {} 

        /** Attribute key for: {@link org.carrot2.util.attribute.BindableDescriptorTest.DefaultValuesTestClass#optional}. */
        public static final String OPTIONAL = "optionalNullValue";
        /** Attribute key for: {@link org.carrot2.util.attribute.BindableDescriptorTest.DefaultValuesTestClass#required}. */
        public static final String REQUIRED = "requiredNullValue";
        /** Attribute key for: {@link org.carrot2.util.attribute.BindableDescriptorTest.DefaultValuesTestClass#nonNull}. */
        public static final String NON_NULL = "nonNull";
        /** Attribute key for: {@link org.carrot2.util.attribute.BindableDescriptorTest.DefaultValuesTestClass#output}. */
        public static final String OUTPUT = "output";
    }


    /* Attribute descriptors. */

    /**
     * All attributes of the {@link org.carrot2.util.attribute.BindableDescriptorTest.DefaultValuesTestClass} component.
     */
    public static final class Attributes
    {
        private Attributes() { /* No public instances. */ }

        /**
         *          */
        public final AttributeInfo optional = 
            new AttributeInfo(
                "optionalNullValue",
                "org.carrot2.util.attribute.BindableDescriptorTest.DefaultValuesTestClass",
                "optional",
                null,
                null,
                null,
                null,
                null,
                null,
                null
            );

        /**
         *          */
        public final AttributeInfo required = 
            new AttributeInfo(
                "requiredNullValue",
                "org.carrot2.util.attribute.BindableDescriptorTest.DefaultValuesTestClass",
                "required",
                null,
                null,
                null,
                null,
                null,
                null,
                null
            );

        /**
         *          */
        public final AttributeInfo nonNull = 
            new AttributeInfo(
                "nonNull",
                "org.carrot2.util.attribute.BindableDescriptorTest.DefaultValuesTestClass",
                "nonNull",
                null,
                null,
                null,
                null,
                null,
                null,
                null
            );

        /**
         *          */
        public final AttributeInfo output = 
            new AttributeInfo(
                "output",
                "org.carrot2.util.attribute.BindableDescriptorTest.DefaultValuesTestClass",
                "output",
                null,
                null,
                null,
                null,
                null,
                null,
                null
            );


    }

    /**
     * Attribute map builder for the  {@link org.carrot2.util.attribute.BindableDescriptorTest.DefaultValuesTestClass} component. You can use this
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
         * @see org.carrot2.util.attribute.BindableDescriptorTest.DefaultValuesTestClass#optional 
         */
        public AttributeBuilder optional(java.lang.String value)
        {
            map.put("optionalNullValue", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * 
         * 
         * @see org.carrot2.util.attribute.BindableDescriptorTest.DefaultValuesTestClass#required 
         */
        public AttributeBuilder required(java.lang.String value)
        {
            map.put("requiredNullValue", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * 
         * 
         * @see org.carrot2.util.attribute.BindableDescriptorTest.DefaultValuesTestClass#nonNull 
         */
        public AttributeBuilder nonNull(java.lang.String value)
        {
            map.put("nonNull", value);
            return this;
        }
        
        
        
        
        
        
        
        
        
        
        
        /**
         * 
         * 
         * @see org.carrot2.util.attribute.BindableDescriptorTest.DefaultValuesTestClass#output 
         */
                public java.lang.String output()
        {
            return (java.lang.String) map.get("output");
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
