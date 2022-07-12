package com.bfly.management.keycloakmanagement.controller;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bfly.management.keycloakmanagement.service.KeycloakService;
import com.bfly.management.model.keycloakmanagement.KeycloakCreateUserReqModel;
import com.bfly.management.model.keycloakmanagement.KeycloakCreteTokenReqModel;

import io.swagger.annotations.Api;
@RestController
@Api( tags = "Keycloak Security")
@RequestMapping(value="/keycloak")
public class KeycloakController {


    @Autowired
    KeycloakService keycloakService;

    @PostMapping("/createtoken")
    public HashMap<String, Object> generateToken(@RequestBody KeycloakCreteTokenReqModel param) throws Exception{
        return keycloakService.GenerateToken(param);
    }
	
    @PostMapping("/createUser")
    public KeycloakCreateUserReqModel createUser(@RequestBody KeycloakCreateUserReqModel param) {
        return keycloakService.createUser(param);
    }

    @PostMapping("/deleteUser")
    public Object deleteUser(@RequestBody KeycloakCreateUserReqModel param) {
        return keycloakService.deleteUser(param);
    }
}