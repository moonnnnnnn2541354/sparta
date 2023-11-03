package com.sparta.springmvc.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
    // static 안에 폴더 불러오기
    @GetMapping("/static-hello")
    public String hello() {
        return "hello.html";
        // url + /hello.html :
        // 직접적으로 static폴더안 자료에 접근
    }

    @GetMapping("/html/redirect")
    public String htmlStatic () {
        return "redirect:/hello.html";
        // url + /html/redirect :
        // controller(get)을 통해 메소드를 실행시켜 자료에 접근
    }

    // templates 의 html 불러오기 
    @GetMapping("/html/templates")
    public String htmlTemplates() {
        return "hello";
        // url + /html/templates :
        // controller(get)을 통해 메소드를 실행시켜 templates안 "hello".html에 접근
    }

    // templates 의 html 불러오기 응용 (조회수)
    private static long visitCount = 0; // 필드값
    @GetMapping("/html/dynamic")
    public String htmlDynamic(Model model) { // Model 치면 자동완성 2개있는데 끝에 ui 인것
        visitCount++; // 실행될적마다 ++
        model.addAttribute("visits",visitCount); // visitcount : "visits"의값
        return "hello-visit"; // templates 안 hello-visit.html 실행
    }

    
}
