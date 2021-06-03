package com.core.service.impl;

import com.core.model.MutableDataObject;
import com.core.repositories.MutableDataObjectRepository;
import com.core.service.MutableDataObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MutableDataObjectServiceImpl implements MutableDataObjectService {

    @Autowired
    MutableDataObjectRepository mutableDataObjectRepository;

    @Override
    public void create(MutableDataObject mutableDataObject) {
        mutableDataObjectRepository.saveAndFlush(mutableDataObject);
    }

    @Override
    public void update(MutableDataObject mutableDataObject) {
        mutableDataObjectRepository.saveAndFlush(mutableDataObject);
    }

    @Override
    public void delete(MutableDataObject mutableDataObject) {
        mutableDataObjectRepository.delete(mutableDataObject);
    }

    @Override
    public MutableDataObject findById(long id) {
        return mutableDataObjectRepository.findById(id).get();
    }

    @Override
    public List<MutableDataObject> findAll() {
        return mutableDataObjectRepository.findAll();
    }

    @Override
    public List<MutableDataObject> getAllChildren(long id) {
        return mutableDataObjectRepository.getAllChildren(id);
    }

    @Override
    public List<MutableDataObject> getChildrenByObjectType(long objectTypeId, long parentId) {
        return mutableDataObjectRepository.getChildrenByObjectType(objectTypeId, parentId);
    }

    @Override
    @Transactional
    public void setStringValue(long objectId, long attrId, String value) {
        mutableDataObjectRepository.setStringValue(objectId, attrId, value);
    }

    @Override
    @Transactional
    public String getValue(long objectId, long attrId) {
        return mutableDataObjectRepository.getValue(objectId, attrId);
    }
}
