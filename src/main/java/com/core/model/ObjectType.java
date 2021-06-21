package com.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "object_types")
public class ObjectType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long objectTypeId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private ObjectType parent;


    @JsonIgnore
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private Set<ObjectType> children = new HashSet<>();

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "objectType")
    private List<MutableDataObject> mutableDataObject;

    @OneToMany(mappedBy = "objectType")
    private List<Attribute> attributes;

    public long getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(long object_type_id) {
        this.objectTypeId = object_type_id;
    }

    public ObjectType getParent() {
        return parent;
    }

    public void setParent(ObjectType parent) {
        this.parent = parent;
    }

    public Set<ObjectType> getChildren() {
        return children;
    }

    public void setChildren(Set<ObjectType> children) {
        this.children = children;
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

    @Override
    public String toString() {
        return "ObjectType{" +
                "objectTypeId=" + objectTypeId +
                ", name='" + name + '\'' +
                ", description='" + description;
    }
}
