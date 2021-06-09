package com.core.service.impl;

import com.core.model.Attribute;
import com.core.repositories.AttributeRepository;
import com.core.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    AttributeRepository attributeRepository;

    @Override
    public void create(Attribute attribute) {
        attributeRepository.save(attribute);
    }

    @Override
    public void update(Attribute attribute) {
        attributeRepository.save(attribute);
    }

    @Override
    public void delete(Attribute attribute) {
        attributeRepository.delete(attribute);
    }

    @Override
    public Attribute findById(long id) {
        return attributeRepository.findById(id).get();
    }

    @Override
    public List<Attribute> findAll() {
        return attributeRepository.findAll();
    }

    @Override
    public List<Attribute> getDefaultAttributesByObjectTypeId(long objectTypeId) {
        return attributeRepository.getDefaultAttributesByObjectTypeId(objectTypeId);
    }
}
