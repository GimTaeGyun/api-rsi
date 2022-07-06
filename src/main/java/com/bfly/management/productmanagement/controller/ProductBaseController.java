package com.bfly.management.productmanagement.controller;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bfly.management.model.UserDto;
// import com.bfly.management.model.KeycloakUserReqModel;
import com.bfly.management.security.KeyCloakAuthentication;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
@Api( tags = "테스트")
@RequestMapping(value="/product")
public class ProductBaseController {


    @Autowired
    KeyCloakAuthentication keyCloakAuthentication;

    @RequestMapping("/createtoken")
    public HashMap<String, Object> hello() throws Exception{
        // keyCloakAuthentication.GenerateToken();
        return keyCloakAuthentication.GenerateToken();
    }
	
    @RequestMapping("/createUser")
    public UserDto tracingTest(@RequestBody UserDto param) {
        return keyCloakAuthentication.createUser(param);
    }
}