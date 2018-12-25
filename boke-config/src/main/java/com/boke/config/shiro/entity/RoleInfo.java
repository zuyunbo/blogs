package com.boke.config.shiro.entity;

import com.boke.common.Base.BaseModel;



public class RoleInfo extends BaseModel {


    private String description;
    private String name;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
