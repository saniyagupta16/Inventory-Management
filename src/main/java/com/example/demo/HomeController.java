package com.example.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by saniya on 26/5/17.
 */
@EnableAutoConfiguration
@Controller
public class HomeController  {
    @RequestMapping("/")

    public String Home(){

        return "index";
    }
}
