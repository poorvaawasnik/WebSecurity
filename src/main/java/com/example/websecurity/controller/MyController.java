package com.example.websecurity.controller;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @RequestMapping("/")
    public  String index(){


        return  "index";
    }

    @RequestMapping("/dashboard")

    public  String dashboard(){return  "Dashboard";}

    @RequestMapping("/user/page")
    public String userPage(){
        return "userPage";
    }

    @RequestMapping("/admin/page")
    public String adminPage(){
        return "adminPage";
    }
    @RequestMapping("/manager/page")
    public String managerPage(){
        return "managerPage";
    }
    @RequestMapping("/about")
    @ResponseBody
    public  String about(){
        return "About Page";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "logout";
    }
}
