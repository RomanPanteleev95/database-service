package com.core.controller;


import com.core.controller.dto.ObjectTypeDTO;
import com.core.model.ObjectType;
import com.core.service.ObjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/database-service")
public class ObjectTypeController {

    @Autowired
    ObjectTypeService objectTypeService;

    @CrossOrigin
    @RequestMapping(value = "/objectType/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<ObjectType> getObjectTypes() {
        return objectTypeService.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/objectType/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createObjectType(@RequestBody ObjectTypeDTO objectTypeDTO) {
        objectTypeService.create(getObjectTypeFromDTO(objectTypeDTO));
    }

    private ObjectType getObjectTypeFromDTO(ObjectTypeDTO objectTypeDTO) {
        ObjectType parentObjectType = objectTypeService.findById(objectTypeDTO.getParentId());
        ObjectType objectType = new ObjectType();
        objectType.setParent(parentObjectType);
        objectType.setName(objectTypeDTO.getName());
        objectType.setDescription(objectTypeDTO.getDescription());
        return objectType;
    }


}
