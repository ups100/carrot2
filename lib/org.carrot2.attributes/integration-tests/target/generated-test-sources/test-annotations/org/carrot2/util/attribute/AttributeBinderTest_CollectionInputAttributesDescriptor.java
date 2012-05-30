

// APT-generated file.

package org.carrot2.util.attribute;


import java.util.*;
import javax.annotation.*;

/**
 * Metadata and attributes of the {@link org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes} component. You can use 
 * this descriptor to obtain metadata, such as human readable name and description, about the component 
 * as a whole as well as about its attributes. Using the {@link #attributeBuilder(Map)}
 * you can obtain a builder for type-safe generation of the attribute maps. Please see the
 * <a href="{@docRoot}/overview-summary.html#setting-attributes">main overview</a> for a complete code example. 
 */
@Generated("Generated from org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes")
public final class CollectionInputAttributesDescriptor implements IBindableDescriptor
{
    /**
     * The component class for which this descriptor was generated. 
     */
    public final String bindableClassName = "org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes";

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
        ownAttrs.add(attributes.list);
        ownAttrs.add(attributes.linkedList);
        ownAttrs.add(attributes.set);
        ownAttrs.add(attributes.linkedHashSet);
        ownAttrs.add(attributes.map);
        ownAttrs.add(attributes.concurrentHashMap);

        final Set<AttributeInfo> allAttrs = new HashSet<AttributeInfo>();
        allAttrs.add(org.carrot2.util.attribute.AttributeBinderTest_CollectionInputAttributesDescriptor.attributes.list);
        allAttrs.add(org.carrot2.util.attribute.AttributeBinderTest_CollectionInputAttributesDescriptor.attributes.linkedList);
        allAttrs.add(org.carrot2.util.attribute.AttributeBinderTest_CollectionInputAttributesDescriptor.attributes.set);
        allAttrs.add(org.carrot2.util.attribute.AttributeBinderTest_CollectionInputAttributesDescriptor.attributes.linkedHashSet);
        allAttrs.add(org.carrot2.util.attribute.AttributeBinderTest_CollectionInputAttributesDescriptor.attributes.map);
        allAttrs.add(org.carrot2.util.attribute.AttributeBinderTest_CollectionInputAttributesDescriptor.attributes.concurrentHashMap);

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
     * Constants for all attribute keys of the {@link org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes} component.
     */
    public static class Keys 
    {
        protected Keys() {} 

        /** Attribute key for: {@link org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes#list}. */
        public static final String LIST = "org.carrot2.util.attribute.AttributeBinderTest$CollectionInputAttributes.list";
        /** Attribute key for: {@link org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes#linkedList}. */
        public static final String LINKED_LIST = "org.carrot2.util.attribute.AttributeBinderTest$CollectionInputAttributes.linkedList";
        /** Attribute key for: {@link org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes#set}. */
        public static final String SET = "org.carrot2.util.attribute.AttributeBinderTest$CollectionInputAttributes.set";
        /** Attribute key for: {@link org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes#linkedHashSet}. */
        public static final String LINKED_HASH_SET = "org.carrot2.util.attribute.AttributeBinderTest$CollectionInputAttributes.linkedHashSet";
        /** Attribute key for: {@link org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes#map}. */
        public static final String MAP = "org.carrot2.util.attribute.AttributeBinderTest$CollectionInputAttributes.map";
        /** Attribute key for: {@link org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes#concurrentHashMap}. */
        public static final String CONCURRENT_HASH_MAP = "org.carrot2.util.attribute.AttributeBinderTest$CollectionInputAttributes.concurrentHashMap";
    }


    /* Attribute descriptors. */

    /**
     * All attributes of the {@link org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes} component.
     */
    public static final class Attributes
    {
        private Attributes() { /* No public instances. */ }

        /**
         *          */
        public final AttributeInfo list = 
            new AttributeInfo(
                "org.carrot2.util.attribute.AttributeBinderTest$CollectionInputAttributes.list",
                "org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes",
                "list",
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
        public final AttributeInfo linkedList = 
            new AttributeInfo(
                "org.carrot2.util.attribute.AttributeBinderTest$CollectionInputAttributes.linkedList",
                "org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes",
                "linkedList",
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
        public final AttributeInfo set = 
            new AttributeInfo(
                "org.carrot2.util.attribute.AttributeBinderTest$CollectionInputAttributes.set",
                "org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes",
                "set",
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
        public final AttributeInfo linkedHashSet = 
            new AttributeInfo(
                "org.carrot2.util.attribute.AttributeBinderTest$CollectionInputAttributes.linkedHashSet",
                "org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes",
                "linkedHashSet",
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
        public final AttributeInfo map = 
            new AttributeInfo(
                "org.carrot2.util.attribute.AttributeBinderTest$CollectionInputAttributes.map",
                "org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes",
                "map",
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
        public final AttributeInfo concurrentHashMap = 
            new AttributeInfo(
                "org.carrot2.util.attribute.AttributeBinderTest$CollectionInputAttributes.concurrentHashMap",
                "org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes",
                "concurrentHashMap",
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
     * Attribute map builder for the  {@link org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes} component. You can use this
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
         * @see org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes#list 
         */
        public AttributeBuilder list(java.util.List<java.lang.String> value)
        {
            map.put("org.carrot2.util.attribute.AttributeBinderTest$CollectionInputAttributes.list", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * 
         * 
         * @see org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes#linkedList 
         */
        public AttributeBuilder linkedList(java.util.LinkedList<java.lang.String> value)
        {
            map.put("org.carrot2.util.attribute.AttributeBinderTest$CollectionInputAttributes.linkedList", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * 
         * 
         * @see org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes#set 
         */
        public AttributeBuilder set(java.util.Set<java.lang.String> value)
        {
            map.put("org.carrot2.util.attribute.AttributeBinderTest$CollectionInputAttributes.set", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * 
         * 
         * @see org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes#linkedHashSet 
         */
        public AttributeBuilder linkedHashSet(java.util.LinkedHashSet<java.lang.String> value)
        {
            map.put("org.carrot2.util.attribute.AttributeBinderTest$CollectionInputAttributes.linkedHashSet", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * 
         * 
         * @see org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes#map 
         */
        public AttributeBuilder map(java.util.Map<java.lang.String,java.lang.String> value)
        {
            map.put("org.carrot2.util.attribute.AttributeBinderTest$CollectionInputAttributes.map", value);
            return this;
        }
        
        
        
        
        
        
        
        /**
         * 
         * 
         * @see org.carrot2.util.attribute.AttributeBinderTest.CollectionInputAttributes#concurrentHashMap 
         */
        public AttributeBuilder concurrentHashMap(java.util.concurrent.ConcurrentHashMap<java.lang.String,java.lang.String> value)
        {
            map.put("org.carrot2.util.attribute.AttributeBinderTest$CollectionInputAttributes.concurrentHashMap", value);
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
