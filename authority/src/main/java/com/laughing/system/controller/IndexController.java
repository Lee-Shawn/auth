package com.laughing.system.controller;

import com.laughing.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: laughing
 * @Create: 2023/10/15 21:35
 * @Description: 后台登录
 * @Version: 1.0
 */
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {
    @PostMapping("/login")
    public Result<Map<String, Object>> login() {
        Map<String, Object> map = new HashMap<>();
        map.put("token", "admin");
        return Result.success(map);
    }

    @GetMapping("/info")
    public Result<Map<String, Object>> info() {
        Map<String, Object> map = new HashMap<>();
        map.put("roles", "[admin]");
        map.put("introduction","I am super administrator");
        map.put("name","Super Admin");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return Result.success(map);
    }
}
