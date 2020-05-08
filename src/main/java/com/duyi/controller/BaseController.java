package com.duyi.controller;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class BaseController {

    private final static Gson gson = new Gson();

    /**
     * 原生方法进行页面回写
     * @param response
     * @param result
     * @param object
     * @throws IOException
     */
    public void writeJson(
            HttpServletResponse response, ResponseStatus result, Object object
    ) throws IOException {
        Map<String, Object> jsonMap = new LinkedHashMap<>();
        jsonMap.put("code", result.getCode());
        jsonMap.put("status", result.getStatus());
        jsonMap.put("data", object);
        String json = gson.toJson(jsonMap);
        response.setCharacterEncoding("utf8");
        response.getWriter().write(json);
    }

    protected AjaxResult success(Object data) {
        return new AjaxResult(200, "success", data);
    }
}

@Data
@AllArgsConstructor
class AjaxResult {
    private Integer code;
    private String status;
    private Object data;
}

enum ResponseStatus {
    SUCCESS(200, "success"),
    FAIL(400, "fail"),

    ;

    private Integer code;
    private String status;

    ResponseStatus(Integer code, String status) {
        this.code = code;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }
}
