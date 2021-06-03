package com.core;

import com.core.model.Attribute;
import com.core.model.AttributeType;
import com.core.model.MutableDataObject;
import com.core.model.ObjectType;
import com.core.service.AttributeService;
import com.core.service.AttributeTypeService;
import com.core.service.MutableDataObjectService;
import com.core.service.ObjectTypeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        new TestRunner().run();
    }

    public void run() throws InterruptedException {
//        ApplicationContext applicationContext = SpringApplication.run(TestRunner.class);
        mutableDataObjectTestRun();
    }

    public void mutableDataObjectTestRun() throws InterruptedException {
        ApplicationContext applicationContext = SpringApplication.run(TestRunner.class);
        MutableDataObjectService mutableDataObjectService = applicationContext.getBean(MutableDataObjectService.class);
        MutableDataObject object = mutableDataObjectService.findById(1L);
        System.out.println((String) object.getValue(10));

    }

    public void objectTypeTestRun() {
        ApplicationContext applicationContext = SpringApplication.run(TestRunner.class);
        ObjectTypeService objectTypeService = applicationContext.getBean(ObjectTypeService.class);
        ObjectType objectType = objectTypeService.findById(2);
        System.out.println(objectType.getName());
    }

    public void attributeTypeTestRun() {
        ApplicationContext applicationContext = SpringApplication.run(TestRunner.class);
        AttributeTypeService attributeTypeService = applicationContext.getBean(AttributeTypeService.class);
        AttributeType attributeType = new AttributeType();
        attributeType.setName("Reference");
        attributeTypeService.create(attributeType);
    }

    public void attributeController() {
        ApplicationContext applicationContext = SpringApplication.run(TestRunner.class);
        AttributeService attributeService = applicationContext.getBean(AttributeService.class);
        Attribute attribute = new Attribute();
        attribute.setName("Test");
        attribute.setDescription("Test description");
        attribute.setDefaultValue("Def val");

        AttributeTypeService attributeTypeService = applicationContext.getBean(AttributeTypeService.class);
        AttributeType attributeType = attributeTypeService.findById(1);
        attribute.setAttributeType(attributeType);
        attributeService.create(attribute);
    }


}
