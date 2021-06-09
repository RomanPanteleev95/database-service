package com.core.service;

import com.core.model.Attribute;
import com.core.model.AttributeType;

import java.util.List;

public interface AttributeService {
    void create(Attribute attribute);
    void update(Attribute attribute);
    void delete(Attribute attribute);
    Attribute findById(long id);
    List<Attribute> findAll();
    List<Attribute> getDefaultAttributesByObjectTypeId(long objectTypeId);
}
