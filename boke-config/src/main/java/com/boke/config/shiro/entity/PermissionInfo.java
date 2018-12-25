package com.boke.config.shiro.entity;

import com.boke.common.Base.BaseModel;

import java.io.Serializable;

/**
 * @author
 * @since 2018
 */
public class PermissionInfo extends BaseModel {


    private String name;
    private String permission;
    private String description;
    private String url;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
