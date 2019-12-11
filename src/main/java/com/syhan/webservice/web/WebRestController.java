package com.syhan.webservice.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {

    @GetMapping("/hellothere")
    public String hellothere(){
        return "Hello Spring boot Web Service world";
    }
}
