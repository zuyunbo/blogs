package com.boke.config.shiro.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.boke.common.Base.BaseModel;

import java.io.Serializable;

/**
 * @since 2018
 */
@TableName(value = "user_info")
public class UserInfo extends BaseModel {


    @TableField(value = "pass_word")
    private String password;
    @TableField(value = "user_name")
    private String username;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
