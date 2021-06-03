package com.core.service.impl;

import com.core.model.AttributeType;
import com.core.repositories.AttributeTypeRepository;
import com.core.service.AttributeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeTypeServiceImpl implements AttributeTypeService {

    @Autowired
    AttributeTypeRepository attributeTypeRepository;

    @Override
    public void create(AttributeType attributeType) {
        attributeTypeRepository.save(attributeType);
    }

    @Override
    public void update(AttributeType attributeType) {
        attributeTypeRepository.save(attributeType);
    }

    @Override
    public void delete(AttributeType attributeType) {
        attributeTypeRepository.delete(attributeType);
    }

    @Override
    public AttributeType findById(long id) {
        return attributeTypeRepository.findById(id).get();
    }

    @Override
    public List<AttributeType> findAll() {
        return attributeTypeRepository.findAll();
    }
}
