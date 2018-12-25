package com.boke.common.Base;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

public class BaseModel implements Serializable {
    private static final long serialVersionUID = 4188086172919649925L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
