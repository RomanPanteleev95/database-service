package com.core.service;

import com.core.model.MutableDataObject;
import com.core.model.ObjectType;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MutableDataObjectService {
    void create(MutableDataObject mutableDataObject);
    void update(MutableDataObject mutableDataObject);
    void delete(MutableDataObject mutableDataObject);
    MutableDataObject findById(long id);
    List<MutableDataObject> findAll();
    List<MutableDataObject> getAllChildren(long id);
    List<MutableDataObject> getChildrenByObjectType(long objectTypeId, long parentId);
    void setStringValue(long objectId, long attrId, String value);
    String getValue(long objectId, long attrId);
}
