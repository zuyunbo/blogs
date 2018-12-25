package com.boke.config.shiro.controller;

import com.alibaba.fastjson.JSONObject;
import com.boke.common.reponse.CommonResponseUtil;
import com.boke.config.shiro.entity.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



/**
 * Created by Administrator on 2017/12/11.
 */
@RestController
public class ShiroController {

    /**
     * 登录方法
     *
     * @param userInfo
     * @return
     */
    @PostMapping(value = "/ajaxLogin")
    public Object ajaxLogin(UserInfo userInfo) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getPassword());
        subject.login(token);
        return CommonResponseUtil.constructResponse(CommonResponseUtil.SUCCESS, "登录成功", "你可以吃一包好兄弟了");
    }

    @ResponseBody
    @RequestMapping(value = "/index")
    public Object unauth() {
        return "没有登录";
    }

}
