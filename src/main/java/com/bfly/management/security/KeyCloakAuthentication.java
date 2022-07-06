package com.bfly.management.security;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import javax.ws.rs.core.Response;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.bfly.management.exception.BusinessException;
import com.bfly.management.model.UserDto;
import com.bfly.management.model.common.ApiCode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
@SuppressWarnings("unchecked")
public class KeyCloakAuthentication {
    @Value("${keycloak.auth-server-url}")
    private String authServerUrl;
  
    @Value("${keycloak.realm}")
    private String realm;
  
    @Value("${keycloak.resource}")
    private String clientId;
  
    @Value("${keycloak.credentials.secret}")
    private String clientSecret;
    
    @Autowired
    WebClient webClient;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    Keycloak keycloak;

    public HashMap<String, Object> GenerateToken() throws Exception{
        HashMap<String, Object> hm = new HashMap<String, Object>();
        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        String realms = "IntegratedManage";
        String uri = String.format("http://192.168.10.198:8080/auth/realms/%s/protocol/openid-connect/token",realms);

        param.add("client_id", "ManageMentAPI");
        param.add("username", "manageuser");
        param.add("grant_type", "password");
        param.add("password", "bfly7714");
        param.add("client_secret", "QIjYFnbEWeBRlGN7EDWH39xGrIk0jXar");

        String result = "";
        
        try{
            // result = webClient.post()
            // .uri(uri)
            // .bodyValue(BodyInserters.fromFormData(param))
            // .retrieve()
            // .bodyToMono(String.class)
            // .block();
            result = WebClient.create()
            .post()
            .uri(uri)
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body(BodyInserters.fromFormData(param))
            .exchange()
            .block()
            .bodyToMono(String.class)
            .block();

        }catch (Exception e) {
            System.out.println(e.getMessage());
            throw new BusinessException(ApiCode.API_TOKEN_CREATE_FAIL);
        }
        hm = objectMapper.readValue(result, HashMap.class);
        

        return hm;
    }

    public UserDto createUser(UserDto userDto) {
        
        // Keycloak keycloak = KeycloakBuilder.builder()
        // .serverUrl("http://192.168.10.198:8080/auth")
        // .realm(realm)
        // // .username("manageuser")
        // // .password("bfly7714")
        // .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
        // .clientId(clientId)
        // .clientSecret(clientSecret)
        // .build();
    
        UserRepresentation user = new UserRepresentation();
        user.setEnabled(true);
        user.setUsername(userDto.getUsername());
        user.setFirstName(userDto.getUsername());
        user.setLastName(userDto.getUsername());
        user.setEmail(userDto.getUsername());
        user.setAttributes(Collections.singletonMap("origin", Arrays.asList("demo")));

        // Get realm
        RealmResource realmResource = keycloak.realm(realm);
        UsersResource usersRessource = realmResource.users();

        // Create user (requires manage-users role)
        Response response = usersRessource.create(user);
        System.out.printf("Repsonse: %s %s%n", response.getStatus(), response.getStatusInfo());
        System.out.println(response.getLocation());
        String userId = CreatedResponseUtil.getCreatedId(response);

        System.out.printf("User created with userId: %s%n", userId);

        // Define password credential
        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(userDto.getPassword());

        UserResource userResource = usersRessource.get(userId);

        // Set password credential
        userResource.resetPassword(passwordCred);

//        // Get realm role "tester" (requires view-realm role)
        RoleRepresentation testerRealmRole = realmResource.roles()//
                .get("default-roles-integratedmanage").toRepresentation();
//
//        // Assign realm role tester to user
        userResource.roles().realmLevel() //
                .add(Arrays.asList(testerRealmRole));
//
//        // Get client
        ClientRepresentation app1Client = realmResource.clients() //
                .findByClientId("ManageMentAPI").get(0);
//
//        // Get client level role (requires view-clients role)
        RoleRepresentation userClientRole = realmResource.clients().get(app1Client.getId()) //
                .roles().get("Manager").toRepresentation();
//
//        // Assign client level role to user
        userResource.roles() //
                .clientLevel(app1Client.getId()).add(Arrays.asList(userClientRole));
    
        userDto.setStatus(response.getStatus());
        userDto.setStatusInfo(response.getStatusInfo().toString());
    
        return userDto;
      }
}
