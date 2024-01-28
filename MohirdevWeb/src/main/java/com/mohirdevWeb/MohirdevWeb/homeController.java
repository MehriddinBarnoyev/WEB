package com.mohirdevWeb.MohirdevWeb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    @GetMapping
public String home(){
        return "home";
    }

    @GetMapping("/message")
    public String message(){
        return "message";
    }

}
