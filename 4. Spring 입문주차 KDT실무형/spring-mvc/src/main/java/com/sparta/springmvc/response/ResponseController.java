package com.sparta.springmvc.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/response") // 각 Mapping들 주소값에 "/response"를 넣음
public class ResponseController {
    // @ResponseBody -> "return값".html 찾는게 아니라 "return값"을 출력해줘

    // 프로그램은 기본적으로 .html을 찾고 없으면 에러를 띄우지만
    // @ResponseBody 써서 "return값"을 출력하게 함
    
    // 기본
    @GetMapping("/json/string")
    @ResponseBody
    public String helloStringJson() {
        return "{\"name\":\"Robbie\",\"age\":95}";
        // Controller Type : text/html
        // Response Body (출력) : {"name":"Robbie","age":95}
    }

    // 응용 : 직접 만든 객체를 써서 출력
    @GetMapping("json/class")
    @ResponseBody
    public Star helloClassJson() {
        return new Star("Robbie",95);
        // Controller Type : text/html
        // Response Body (출력) : {"name":"Robbie","age":95}
    }
}
