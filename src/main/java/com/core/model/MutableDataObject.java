package com.core.model;

import com.core.service.AttributeService;
import com.core.service.MutableDataObjectService;
import com.core.util.ApplicationContextProvider;
import org.springframework.context.ApplicationContext;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "objects")
public class MutableDataObject {

    @Transient
    private Map<Long, Object> params = new HashMap<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long objectId;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private MutableDataObject parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<MutableDataObject> children = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "object_type_id")
    private ObjectType objectType;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Transient
    private ApplicationContext applicationContext = ApplicationContextProvider.getContext();

    public long getId() {
        return objectId;
    }

    public void setId(long object_id) {
        this.objectId = object_id;
    }

    public MutableDataObject getParent() {
        return parent;
    }

    public void setParent(MutableDataObject parent) {
        this.parent = parent;
    }

    public List<MutableDataObject> getChildren() {
        MutableDataObjectService mutableDataObjectService = applicationContext.getBean(MutableDataObjectService.class);
        return mutableDataObjectService.getAllChildren(this.objectId);
    }

    public List<MutableDataObject> getChildrenByObjectType(long objectTypeId) {
        MutableDataObjectService mutableDataObjectService = applicationContext.getBean(MutableDataObjectService.class);
        return mutableDataObjectService.getChildrenByObjectType(objectTypeId, this.objectId);
    }

    public void setChildren(List<MutableDataObject> children) {
        this.children = children;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
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

    public Long getParentId() {
        return getParent().getId();
    }

    public void setValue(long attrId, Object value) {
        //TODO: add object type validation
        params.put(attrId, value);
        MutableDataObjectService mutableDataObjectService = applicationContext.getBean(MutableDataObjectService.class);
        //TODO: add validation for date_value and list value
        if (value instanceof String) {
            mutableDataObjectService.setStringValue(this.objectId, attrId, (String) value);
        }
        if (value instanceof Date) {
            mutableDataObjectService.setDateValue(this.objectId, attrId, (Date) value);
        }
    }

    public Object getValue(long attrId) {
        Object value = params.get(attrId);
        if (value == null) {
            MutableDataObjectService mutableDataObjectService = applicationContext.getBean(MutableDataObjectService.class);
            AttributeService attributeService = applicationContext.getBean(AttributeService.class);
            Attribute attribute = attributeService.findById(attrId);
            if (attribute.getAttributeType().getAttributeTypeId() == 3) {
                value = mutableDataObjectService.getDateValue(this.objectId, attrId);
            } else if(attribute.getAttributeType().getAttributeTypeId() == 4) {
                value = mutableDataObjectService.getListValue(this.objectId, attrId);
            } else {
                value = mutableDataObjectService.getStringValue(this.objectId, attrId);
            }
        }
        params.put(attrId, value);
        return value;
    }

    public Map<Long, Object> getParams() {
        return params;
    }

    @Override
    public String toString() {
        return "MutableDataObject{" +
                "object_id=" + objectId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
