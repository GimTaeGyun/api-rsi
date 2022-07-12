package com.bfly.management.model.keycloakmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Token 발급 REQ")
public class KeycloakCreteTokenReqModel {
    
    @ApiModelProperty(notes = "User ID", example = "test")
    private String userId;
    
    @ApiModelProperty(notes = "Realm Name", example = "ManageMentAPI")
    private String realm;

    @ApiModelProperty(notes = "Client ID", example = "ApplicationClient")
    private String clientId;

    @ApiModelProperty(notes = "Client Secret", example = "C83UaObpMgTl66o8eaCbeuL9y7qHCvhr")
    private String clientSecret;

    @ApiModelProperty(notes = "Token Url", example = "http://192.168.10.198:8080/auth/realms/%s/protocol/openid-connect/token")
    private String tokenServerUrl;
}
