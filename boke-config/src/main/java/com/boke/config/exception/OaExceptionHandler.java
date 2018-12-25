package com.boke.config.exception;

import com.boke.common.reponse.CommonResponseUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class OaExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(OaExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object defaulErrorHandler(Exception e) {
        log.error("handle error:", e);
        if (e instanceof UnauthorizedException) {
            return CommonResponseUtil.constructResponse(CommonResponseUtil.FAILED_STAY, e.toString(), "用户没有权限，作元");
        } else if (e instanceof IncorrectCredentialsException) {
            return CommonResponseUtil.constructResponse(CommonResponseUtil.FAILED_STAY, e.toString(), "用户密码错误，作元");
        } else if (e instanceof AuthenticationException) {
            return CommonResponseUtil.constructResponse(CommonResponseUtil.FAILED_STAY, e.toString(), "用户不存在，作元");
        }
        return CommonResponseUtil.constructResponse(CommonResponseUtil.FAILED_STAY, e.toString(), "此功能正在维护，作元");
    }

    @ExceptionHandler(value = IllegalParameterException.class)
    @ResponseBody
    public Object IllegalParameterExceptionHandler(IllegalParameterException ille) {
        log.error("handle error:", ille);
        return CommonResponseUtil.constructResponse(CommonResponseUtil.FAILED, ille.toString(), "正常流程");
    }


}
