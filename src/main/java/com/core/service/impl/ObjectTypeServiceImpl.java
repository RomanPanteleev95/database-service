package com.core.service.impl;

import com.core.model.ObjectType;
import com.core.repositories.ObjectTypeRepository;
import com.core.service.ObjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ObjectTypeServiceImpl implements ObjectTypeService {

    @Autowired
    ObjectTypeRepository objectTypeRepository;

    @Override
    public void create(ObjectType objectType) {
        objectTypeRepository.saveAndFlush(objectType);
    }

    @Override
    public void update(ObjectType objectType) {
        objectTypeRepository.saveAndFlush(objectType);
    }

    @Override
    public void delete(ObjectType objectType) {
        objectTypeRepository.delete(objectType);
    }

    @Override
    public ObjectType findById(long id) {
        return objectTypeRepository.findById(id).get();
    }

    @Override
    public List<ObjectType> findAll() {
        return objectTypeRepository.findAll();
    }
}
