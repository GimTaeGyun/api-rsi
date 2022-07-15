package com.bfly.management.keycloakmanagement.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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

import com.bfly.management.config.CustomKeycloak;
import com.bfly.management.exception.BusinessException;
import com.bfly.management.model.common.ApiCode;
import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.common.CommonCode;
import com.bfly.management.model.keycloakmanagement.KeycloakCreateUserReqModel;
import com.bfly.management.model.keycloakmanagement.KeycloakCreteTokenReqModel;
import com.bfly.management.model.keycloakmanagement.KeycloakRefreshTokenReqModel;

import lombok.extern.slf4j.Slf4j;



/**
 * 
 */
@Slf4j
@Service
public class KeycloakService extends KeycloakBaseService{

    @Value("${customvalues.keycloak.tokenUrl}")
    private String tokenUrl;

    @Value("${keycloak.auth-server-url}")
    private String authServerUrl;


    public KeycloakCreateUserReqModel createUser(KeycloakCreateUserReqModel param) {

        Keycloak keycloak = new CustomKeycloak(
                param.getAuthServerUrl(),   // 인증 URL
                param.getRealm(),           // Realm 이름
                param.getClientId(),        // Client ID
                param.getClientSecret(),    // Client Credential
                param.getAdminId(),         // 관리자 ID
                param.getAdminPw() 
        ).getKeycloak();
    
        UserRepresentation user = new UserRepresentation();
        user.setEnabled(true);
        user.setUsername(param.getUserId());
        user.setFirstName(param.getUserId());
        user.setLastName(param.getUserId());
        user.setEmail(param.getUserId());
        user.setAttributes(Collections.singletonMap("origin", Arrays.asList("demo")));

        // Get realm
        RealmResource realmResource = keycloak.realm(param.getRealm());
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
        passwordCred.setValue(param.getUserPw());

        UserResource userResource = usersRessource.get(userId);

        // Set password credential
        userResource.resetPassword(passwordCred);

        // Get realm role "tester" (requires view-realm role)
        RoleRepresentation testerRealmRole = realmResource.roles()//
                .get("Application").toRepresentation();

//        // Assign realm role tester to user
        userResource.roles().realmLevel() //
                .add(Arrays.asList(testerRealmRole));
//
//        // Get client
        ClientRepresentation app1Client = realmResource.clients() //
                .findByClientId(param.getClientId()).get(0);

//        // Get client level role (requires view-clients role)
        RoleRepresentation userClientRole = realmResource.clients().get(app1Client.getId()) //
                .roles().get(param.getRoles().getCode()).toRepresentation();

//        // Assign client level role to user
        userResource.roles() //
                .clientLevel(app1Client.getId()).add(Arrays.asList(userClientRole));
    
        param.setStatus(response.getStatus());
        param.setStatusInfo(response.getStatusInfo().toString());
    
        return param;
    }


    public HashMap<String, Object> GenerateToken(KeycloakCreteTokenReqModel param) throws Exception
    {
        HashMap<String, Object> hm = new HashMap<String, Object>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String uri = String.format(tokenUrl, param.getRealm());

        params.add("client_id", param.getClientId());
        params.add("username", param.getUserId());
        params.add("grant_type", "password");
        params.add("password", "Pa$$w0rd");
        params.add("client_secret", param.getClientSecret());

        String result = "";
        
        try{
        result = WebClient.create()
            .post()
            .uri(uri)
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body(BodyInserters.fromFormData(params))
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

    
    public HashMap<String, Object> GenerateToken() throws Exception
    {
        HashMap<String, Object> hm = new HashMap<String, Object>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String uri = String.format(tokenUrl, "ManageMentAPI");

        params.add("client_id", "ApplicationClient");
        params.add("username", "bflysoft");
        params.add("grant_type", "password");
        params.add("password", "Pa$$w0rd");
        params.add("client_secret", "2bEioqNZ5snuOcf7QOHkzKkrfhk9tgH1");

        String result = "";
        
        try{
        result = WebClient.create()
            .post()
            .uri(uri)
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body(BodyInserters.fromFormData(params))
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


    public List<UserRepresentation> findUser(Keycloak keycloak, UsersResource usersRessource, String userId, String realm) {
        
        
        List<UserRepresentation> user = usersRessource.search(userId, true);

        return user;
    }

    public ApiResult<?> deleteUser(KeycloakCreateUserReqModel param) {
        Keycloak keycloak = new CustomKeycloak(
        param.getAuthServerUrl(),   // 인증 URL
        param.getRealm(),           // Realm 이름
        param.getClientId(),        // Client ID
        param.getClientSecret(),    // Client Credential
        param.getAdminId(),         // 관리자 ID
        param.getAdminPw() 
        ).getKeycloak();

        RealmResource realmResource = keycloak.realm(param.getRealm());
        UsersResource usersRessource = realmResource.users();
        
        List<UserRepresentation> user = findUser(keycloak, usersRessource, param.getUserId(), param.getRealm());

        if ( user.size() == 1 ) {
            usersRessource.get(user.get(0).getId()).remove();
            return new ApiResult<>(CommonCode.COMMON_SUCCESS, null);
        }else {
            return new ApiResult<>(CommonCode.COMMON_FAIL, null);
        }
    }

    public HashMap<String, Object> refreshToken(KeycloakRefreshTokenReqModel param) throws Exception
    {
        HashMap<String, Object> hm = new HashMap<String, Object>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        
        String uri = String.format(tokenUrl, param.getRealm());

        params.add("client_id", param.getClientId());
        params.add("client_secret", param.getClientSecret());
        params.add("refresh_token", param.getRefreshToken());
        params.add("grant_type", "refresh_token");

        String result = "";
        
        try{
        result = WebClient.create()
            .post()
            .uri(uri)
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body(BodyInserters.fromFormData(params))
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
}
