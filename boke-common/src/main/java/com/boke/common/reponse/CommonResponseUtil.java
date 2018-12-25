package com.boke.common.reponse;

import java.util.HashMap;
import java.util.Map;

/**
 *  返回基类
 */
public class CommonResponseUtil {

    /**
     * 请求成功
     */
    public static final int SUCCESS = 1;

    /**
     * 请求异常
     */
    public static final int FAILED = -1;

    /**
     * 请求异常,保留错误提示在界面
     */
    public static final int FAILED_STAY = -2;

    public static Map<String, Object> constructResponse(int code, String msg) {
        Map<String, Object> jo = new HashMap<>(3);
        jo.put("code", code);
        jo.put("msg", msg);
        jo.put("data", null);
        return jo;
    }

    public static Map<String, Object> constructResponse(int code, String msg, Object data) {
        Map<String, Object> jo = new HashMap<>(3);
        jo.put("code", code);
        jo.put("msg", msg);
        jo.put("data", data);
        return jo;
    }
}
