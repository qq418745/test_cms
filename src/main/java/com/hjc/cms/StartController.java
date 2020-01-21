package com.hjc.cms;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * hjc_cms
 * Mr.liuchengming
 * 2019-12-19 12:04
 **/
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