package com.webing.app_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aboutus")
public class AboutUsController {
    
    @GetMapping()
    public String AboutUs(){
        return "AboutUs 2";
    }
}
