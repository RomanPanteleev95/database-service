package com.core.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attribute_types")
public class AttributeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_type_id")
    private long attributeTypeId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "attributeType")
    private List<Attribute> attributes;

    public long getAttributeTypeId() {
        return attributeTypeId;
    }

    public void setAttributeTypeId(long attribute_type_id) {
        this.attributeTypeId = attribute_type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
