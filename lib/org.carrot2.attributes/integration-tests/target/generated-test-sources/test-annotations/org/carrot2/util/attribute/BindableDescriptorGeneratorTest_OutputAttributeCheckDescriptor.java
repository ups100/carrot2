

// APT-generated file.

package org.carrot2.util.attribute;


import java.util.*;
import javax.annotation.*;

/**
 * Metadata and attributes of the {@link org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck} component. You can use 
 * this descriptor to obtain metadata, such as human readable name and description, about the component 
 * as a whole as well as about its attributes. Using the {@link #attributeBuilder(Map)}
 * you can obtain a builder for type-safe generation of the attribute maps. Please see the
 * <a href="{@docRoot}/overview-summary.html#setting-attributes">main overview</a> for a complete code example. 
 */
@Generated("Generated from org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck")
public final class OutputAttributeCheckDescriptor implements IBindableDescriptor
{
    /**
     * The component class for which this descriptor was generated. 
     */
    public final String bindableClassName = "org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck";

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
        ownAttrs.add(attributes.inout);
        ownAttrs.add(attributes.in);
        ownAttrs.add(attributes.out);
        ownAttrs.add(attributes.inoutRef);
        ownAttrs.add(attributes.inRef);
        ownAttrs.add(attributes.outRef);

        final Set<AttributeInfo> allAttrs = new HashSet<AttributeInfo>();
        allAttrs.add(org.carrot2.util.attribute.BindableDescriptorGeneratorTest_OutputAttributeCheckDescriptor.attributes.inout);
        allAttrs.add(org.carrot2.util.attribute.BindableDescriptorGeneratorTest_OutputAttributeCheckDescriptor.attributes.in);
        allAttrs.add(org.carrot2.util.attribute.BindableDescriptorGeneratorTest_OutputAttributeCheckDescriptor.attributes.out);
        allAttrs.add(org.carrot2.util.attribute.BindableDescriptorGeneratorTest_OutputAttributeCheckDescriptor.attributes.inoutRef);
        allAttrs.add(org.carrot2.util.attribute.BindableDescriptorGeneratorTest_OutputAttributeCheckDescriptor.attributes.inRef);
        allAttrs.add(org.carrot2.util.attribute.BindableDescriptorGeneratorTest_OutputAttributeCheckDescriptor.attributes.outRef);

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
     * Constants for all attribute keys of the {@link org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck} component.
     */
    public static class Keys 
    {
        protected Keys() {} 

        /** Attribute key for: {@link org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck#inout}. */
        public static final String INOUT = "org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.inout";
        /** Attribute key for: {@link org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck#in}. */
        public static final String IN = "org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.in";
        /** Attribute key for: {@link org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck#out}. */
        public static final String OUT = "org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.out";
        /** Attribute key for: {@link org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck#inoutRef}. */
        public static final String INOUT_REF = "org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.inoutRef";
        /** Attribute key for: {@link org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck#inRef}. */
        public static final String IN_REF = "org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.inRef";
        /** Attribute key for: {@link org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck#outRef}. */
        public static final String OUT_REF = "org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.outRef";
    }


    /* Attribute descriptors. */

    /**
     * All attributes of the {@link org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck} component.
     */
    public static final class Attributes
    {
        private Attributes() { /* No public instances. */ }

        /**
         *          */
        public final AttributeInfo inout = 
            new AttributeInfo(
                "org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.inout",
                "org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck",
                "inout",
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
        public final AttributeInfo in = 
            new AttributeInfo(
                "org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.in",
                "org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck",
                "in",
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
        public final AttributeInfo out = 
            new AttributeInfo(
                "org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.out",
                "org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck",
                "out",
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
        public final AttributeInfo inoutRef = 
            new AttributeInfo(
                "org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.inoutRef",
                "org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck",
                "inoutRef",
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
        public final AttributeInfo inRef = 
            new AttributeInfo(
                "org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.inRef",
                "org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck",
                "inRef",
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
        public final AttributeInfo outRef = 
            new AttributeInfo(
                "org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.outRef",
                "org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck",
                "outRef",
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
     * Attribute map builder for the  {@link org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck} component. You can use this
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
         * @see org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck#inout 
         */
        public AttributeBuilder inout(int value)
        {
            map.put("org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.inout", value);
            return this;
        }
        
        
        
        
        
        /**
         * 
         * 
         * @see org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck#inout 
         */
                public int inout()
        {
            return (java.lang.Integer) map.get("org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.inout");
        }
        
        
        
        /**
         * 
         * 
         * @see org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck#in 
         */
        public AttributeBuilder in(int value)
        {
            map.put("org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.in", value);
            return this;
        }
        
        
        
        
        
        
        
        
        
        
        
        /**
         * 
         * 
         * @see org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck#out 
         */
                public int out()
        {
            return (java.lang.Integer) map.get("org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.out");
        }
        
        
        
        /**
         * 
         * 
         * @see org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck#inoutRef 
         */
        public AttributeBuilder inoutRef(org.carrot2.util.attribute.BindableDescriptorGeneratorTest.A value)
        {
            map.put("org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.inoutRef", value);
            return this;
        }
        
        
        
        /**
         * 
         * 
         * @see org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck#inoutRef
         */
        public AttributeBuilder inoutRef(Class<? extends org.carrot2.util.attribute.BindableDescriptorGeneratorTest.A> clazz)
        {
            map.put("org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.inoutRef", clazz);
            return this;
        }
        
        
        
        /**
         * 
         * 
         * @see org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck#inoutRef 
         */
                public org.carrot2.util.attribute.BindableDescriptorGeneratorTest.A inoutRef()
        {
            return (org.carrot2.util.attribute.BindableDescriptorGeneratorTest.A) map.get("org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.inoutRef");
        }
        
        
        
        /**
         * 
         * 
         * @see org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck#inRef 
         */
        public AttributeBuilder inRef(org.carrot2.util.attribute.BindableDescriptorGeneratorTest.A value)
        {
            map.put("org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.inRef", value);
            return this;
        }
        
        
        
        /**
         * 
         * 
         * @see org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck#inRef
         */
        public AttributeBuilder inRef(Class<? extends org.carrot2.util.attribute.BindableDescriptorGeneratorTest.A> clazz)
        {
            map.put("org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.inRef", clazz);
            return this;
        }
        
        
        
        
        
        
        
        
        
        /**
         * 
         * 
         * @see org.carrot2.util.attribute.BindableDescriptorGeneratorTest.OutputAttributeCheck#outRef 
         */
                public org.carrot2.util.attribute.BindableDescriptorGeneratorTest.A outRef()
        {
            return (org.carrot2.util.attribute.BindableDescriptorGeneratorTest.A) map.get("org.carrot2.util.attribute.BindableDescriptorGeneratorTest$OutputAttributeCheck.outRef");
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
