package com.core.util;

import com.core.model.Attribute;
import com.core.model.MutableDataObject;
import com.core.model.ObjectType;
import com.core.service.AttributeService;
import com.core.service.MutableDataObjectService;
import com.core.service.ObjectTypeService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DataObjectManager {
    private static ApplicationContext applicationContext = ApplicationContextProvider.getContext();

    public static MutableDataObject createDataObject(Long objectTypeId, Long parentId) {
        MutableDataObject mutableDataObject = new MutableDataObject();
        ObjectType objectType = getObjectType(objectTypeId);
        mutableDataObject.setObjectType(objectType);
        mutableDataObject.setName(objectType.getName() + "test");
        MutableDataObject parentObject = applicationContext.getBean(MutableDataObjectService.class).findById(parentId);
        mutableDataObject.setParent(parentObject);
        mutableDataObject = applicationContext.getBean(MutableDataObjectService.class).create(mutableDataObject);
        fillDefaultAttributes(mutableDataObject, objectTypeId);


        return mutableDataObject;

    }

    private static ObjectType getObjectType(Long objectTypeId) {
        ObjectTypeService objectTypeService = applicationContext.getBean(ObjectTypeService.class);
        ObjectType objectType = objectTypeService.findById(objectTypeId);
        return objectType;
    }

    private static void fillDefaultAttributes(MutableDataObject mutableDataObject, Long objectTypeId) {
        mutableDataObject.setValue(2, new Date());
        mutableDataObject.setValue(5, "admin");


        AttributeService attributeService = applicationContext.getBean(AttributeService.class);
        List<Attribute> attributes = attributeService.getDefaultAttributesByObjectTypeId(objectTypeId);
        for (Attribute attribute : attributes) {
            mutableDataObject.setValue(attribute.getAttribute_id(), attribute.getDefaultValue());
        }
    }

}
