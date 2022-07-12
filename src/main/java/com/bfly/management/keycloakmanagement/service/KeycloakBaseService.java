package com.bfly.management.keycloakmanagement.service;

import org.keycloak.admin.client.Keycloak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * 
 */
@Service
public class KeycloakBaseService {
    @Autowired
    ObjectMapper objectMapper;
}
