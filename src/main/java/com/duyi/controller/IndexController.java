package com.duyi.controller;

import com.duyi.service.ShlynService;
import com.duyi.annotation.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Controller
public class IndexController extends BaseController {

    @Autowired
    ShlynService shlynService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    @Log(title = "首页")
    public AjaxResult index(
            HttpServletRequest request,
            @RequestParam(name = "a", required = false) String a,
            // @CookieValue("cookie1") String cookies,
            HttpServletResponse response) throws IOException {
        System.out.println("index 方法");
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("name", "Sf");
        map.put("camp", "nightmare");
        map.put("equips", new String[]{"假腿", "跳刀", "幻影斧", "冰眼"});
        // writeJson(response, ResponseStatus.SUCCESS, map);
        // CharacterEncodingFilter
        return success(map);
    }

    public AjaxResult get(@NotNull @Min(1) Long id) {
        return success("");
    }
}
