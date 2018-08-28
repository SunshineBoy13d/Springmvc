package cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello/*")
public class HelloWord {
    @ResponseBody
    @RequestMapping("/word")
    public String hello(){
       return  "Hello word";
    }
}
