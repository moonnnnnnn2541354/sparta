package com.sparta.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api") // 각 Mapping들 주소값에 "/api"를 넣음
public class HelloController {
    @GetMapping("/hello") // /api/hello
    @ResponseBody
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/get") // /api/get
    @ResponseBody
    public String get() {
        return "GET Method 요청";
    }

    @PostMapping("/post") // /api/post
    @ResponseBody
    public String post() {
        return "POST Method 요청";
    }

    @PutMapping("/put") // /api/put
    @ResponseBody
    public String put() {
        return "PUT Method 요청";
    }

    @DeleteMapping("/delete") // /api/delet
    @ResponseBody
    public String delete() {
        return "DELETE Method 요청";
    }
}
