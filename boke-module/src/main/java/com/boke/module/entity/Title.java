package com.boke.module.entity;


import com.boke.module.common.BaseEntity;

import javax.persistence.Entity;

/**
 * @author zu
 */
@Entity(name = "title")
public class Title extends BaseEntity{

    private String name;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

