package com.hjc.cms;
/**
 * @program: hjc_cms
 * @description:
 * @author: Mr.liuchengming
 * @create: 2019-12-19 12:04
 **/


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class StartController {


    @RequestMapping("/login")
    public String login() {
        return "login.html";
    }


    @RequestMapping("/pages/home")
    public String helloWorld() {
        return "index.html";
    }

}