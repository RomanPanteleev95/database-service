package com.core.service;

import com.core.model.AttributeType;

import java.util.List;

public interface AttributeTypeService {
    void create(AttributeType attributeType);
    void update(AttributeType attributeType);
    void delete(AttributeType attributeType);
    AttributeType findById(long id);
    List<AttributeType> findAll();
}
