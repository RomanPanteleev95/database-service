package com.core.controller;

import com.core.controller.dto.MutableDataObjectDTO;
import com.core.model.Attribute;
import com.core.model.MutableDataObject;
import com.core.service.AttributeService;
import com.core.util.ApplicationContextProvider;
import com.core.util.DataObjectManager;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/database-service")
public class MutableDataObjectController {

    @RequestMapping(value = "/object/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody MutableDataObjectDTO createObjectByObjectTypeId(@RequestBody MutableDataObjectDTO mutableDataObjectDTO) {
        MutableDataObject mutableDataObject = DataObjectManager.createDataObject(mutableDataObjectDTO.getObjectTypeId(),
                mutableDataObjectDTO.getParentId());
        return getMutableDto(mutableDataObject);
    }

    private MutableDataObjectDTO getMutableDto(MutableDataObject mutableDataObject) {
        MutableDataObjectDTO mutableDataObjectDTO = new MutableDataObjectDTO();
        mutableDataObjectDTO.setId(mutableDataObject.getId());
        mutableDataObjectDTO.setName(mutableDataObject.getName());
        mutableDataObjectDTO.setObjectTypeId(mutableDataObject.getObjectType().getObjectTypeId());
        mutableDataObjectDTO.setParentId(mutableDataObject.getParentId());
        Map<Long, Object> params = mutableDataObject.getParams();
        Map<String, Object> distAttributes = new HashMap<>();
        AttributeService attributeService = ApplicationContextProvider.getContext().getBean(AttributeService.class);
        for (Map.Entry<Long, Object> param : params.entrySet()) {
            Attribute attribute = attributeService.findById(param.getKey());
            distAttributes.put(attribute.getName(), param.getValue());
        }
        mutableDataObjectDTO.setAttributes(distAttributes);
        return mutableDataObjectDTO;
    }
}
