package com.bfly.management.productmanagement.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
@RestController
@Api( tags = "테스트")
@RequestMapping(value="/test")
public class ProductBaseController {


    @RequestMapping("/hello")
    public String hello() {
        return "Hello KeyCloak!";
    }
	
    @RequestMapping("/app1")
    public String tracingTest() {
        return "This is permitAll!";
    }
}