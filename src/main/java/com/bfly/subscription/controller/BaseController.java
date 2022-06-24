package com.bfly.subscription.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Api( tags = "테스트")
@RequestMapping(value="/test")
public class BaseController {


    @RequestMapping(value = "/test", method=RequestMethod.GET, produces="application/json;charset=UTF-8")
    public String logingcodecertification(
        @RequestBody String paramStr
    		) throws Exception{
		return "Success";
    }
    
}
