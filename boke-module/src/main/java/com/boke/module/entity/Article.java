package com.boke.module.entity;

import com.boke.module.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author zu
 */
@Entity(name = "article")
public class Article extends BaseEntity {

    @Column(name = "title_id")
    private Integer titleId;

    private String name;

    private String value;


    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

