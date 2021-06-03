package com.core.controller;

import com.core.controller.dto.AttributeDTO;
import com.core.controller.dto.ObjectTypeDTO;
import com.core.model.Attribute;
import com.core.model.AttributeType;
import com.core.model.ObjectType;
import com.core.service.AttributeService;
import com.core.service.AttributeTypeService;
import com.core.service.ObjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/database-service")
public class AttributeController {

    @Autowired
    AttributeService attributeService;

    @Autowired
    ObjectTypeService objectTypeService;

    @Autowired
    AttributeTypeService attributeTypeService;

    @RequestMapping(value = "/attribute/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createAttribute(@RequestBody AttributeDTO attributeDTO) {
        attributeService.create(getObjectTypeFromDTO(attributeDTO));
    }

    private Attribute getObjectTypeFromDTO(AttributeDTO attributeDTO) {
        Attribute attribute = new Attribute();
        attribute.setName(attributeDTO.getName());

        AttributeType attributeType = attributeTypeService.findById(attributeDTO.getAttributeTypeId());
        attribute.setAttributeType(attributeType);

        attribute.setDescription(attributeDTO.getDescription());
        attribute.setDefaultValue(attributeDTO.getDefaultValue());

        ObjectType objectType = objectTypeService.findById(attributeDTO.getObjectTypeId());
        attribute.setObjectType(objectType);

        return attribute;
    }
}
