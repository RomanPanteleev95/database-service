package com.core.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attribute_types")
public class AttributeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long attribute_type_id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "attributeType")
    private List<Attribute> attributes;

    public long getAttribute_type_id() {
        return attribute_type_id;
    }

    public void setAttribute_type_id(long attribute_type_id) {
        this.attribute_type_id = attribute_type_id;
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
