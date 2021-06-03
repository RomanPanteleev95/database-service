package com.core.service;

import com.core.model.MutableDataObject;
import com.core.model.ObjectType;

import java.util.List;

public interface ObjectTypeService {
    void create(ObjectType objectType);
    void update(ObjectType objectType);
    void delete(ObjectType objectType);
    ObjectType findById(long id);
    List<ObjectType> findAll();
}
