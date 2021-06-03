package com.core.controller.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ObjectTypeDTO {
    @JsonProperty("parentId")
    private long parentId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
