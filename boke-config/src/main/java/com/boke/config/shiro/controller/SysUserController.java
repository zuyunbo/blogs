package com.boke.config.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/1/15.
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserController.class);

    /**
     * AR 部分测试
     */
    @GetMapping("/test1")
    public String test1() {
        return "123456";
    }



    @RequestMapping("/userList")
    @RequiresPermissions("user:view")//权限管理;
    public String userList() {
        LOGGER.info("pageNum = {}, pageSize = {}");

        return "你终于可以抽根烟冷静一下了";
    }


}
