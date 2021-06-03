package com.core.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributeDTO {

    @JsonProperty("objectTypeId")
    private long objectTypeId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("attributeTypeId")
    private long attributeTypeId;

    @JsonProperty("description")
    private String description;

    @JsonProperty("defaultValue")
    private String defaultValue;

    public long getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(long objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAttributeTypeId() {
        return attributeTypeId;
    }

    public void setAttributeTypeId(long attributeTypeId) {
        this.attributeTypeId = attributeTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
