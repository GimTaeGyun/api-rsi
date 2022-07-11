package com.bfly.management.keycloakmanagement.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

@RestController
@Api( tags = "BASE")
@RequestMapping(value="/keycloak")
public class KeycloakBaseController {

}