package com.hsc.tacocloud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 控制器
public class HomeController {
    @GetMapping("/") // 处理对根路径的请求
    public String home() {
        return "home";
    }
}