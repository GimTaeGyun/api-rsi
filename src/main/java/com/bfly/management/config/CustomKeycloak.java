package com.bfly.management.config;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

public class CustomKeycloak{
    
    private String authServerUrl;
    private String realm;
    private String clientId;
    private String clientSecret;
    private String adminId;
    private String adminPw;
    

    public CustomKeycloak(
                    String authServerUrl,   // 인증 URL
                    String realm,           // Realm 이름
                    String clientId,        // Client ID
                    String clientSecret,    // Client Credential
                    String adminId,         // 관리자 ID
                    String adminPw          // 관리자 PW
                    )
    {
        this.authServerUrl = authServerUrl;
        this.realm = realm;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.adminId = adminId;
        this.adminPw = adminPw;
    
    }

    public Keycloak getKeycloak(){
        return KeycloakBuilder
        .builder()
        .serverUrl(this.authServerUrl)
        .realm(this.realm)
        .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
        .clientId(this.clientId)
        .clientSecret(this.clientSecret)
        .username(this.adminId)
        .password(this.adminPw)
        .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build())
        .build();
    }
}
