package com.core.model;

import javax.persistence.*;

@Entity
@Table(name = "attributes")
@org.hibernate.annotations.NamedNativeQuery(
        name = "get_default_attrs",
        query = "with recursive tmp as (\n" +
                "    select object_type_id, parent_id from object_types where object_type_id = :objectTypeId\n" +
                "    union all\n" +
                "    select ot.object_type_id, t.parent_id from tmp t\n" +
                "    inner join object_types ot on ot.parent_id = t.object_type_id\n" +
                "\n" +
                ") select * from\n" +
                "    attributes attr,\n" +
                "    tmp t\n" +
                "where t.object_type_id = attr.object_type_id " +
                "and attr.default_value is not null",
        resultClass = Attribute.class
)
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long attribute_id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attribute_type_id")
    private AttributeType attributeType;

    @Column(name = "description")
    private String description;

    @Column(name = "default_value")
    private String defaultValue;

    @ManyToOne
    @JoinColumn(name = "object_type_id")
    private ObjectType objectType;

    public long getAttribute_id() {
        return attribute_id;
    }

    public void setAttribute_id(long attribute_id) {
        this.attribute_id = attribute_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AttributeType getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(AttributeType attributeType) {
        this.attributeType = attributeType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }
}
