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

    @RequestMapping("/about")
    @ResponseBody
    public  String about(){
        return "About Page";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
