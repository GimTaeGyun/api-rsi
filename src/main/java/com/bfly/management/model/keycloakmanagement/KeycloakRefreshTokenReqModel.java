package com.bfly.management.model.keycloakmanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Refresh Token 발급 REQ")
public class KeycloakRefreshTokenReqModel {

    @ApiModelProperty(notes = "Realm Name", example = "ManageMentAPI")
    private String realm;

    @ApiModelProperty(notes = "Client ID", example = "ApplicationClient")
    private String clientId;

    @ApiModelProperty(notes = "Client Secret", example = "2bEioqNZ5snuOcf7QOHkzKkrfhk9tgH1")
    private String clientSecret;

    @ApiModelProperty(notes = "Refresh Token", example = "")
    private String refreshToken;

    @ApiModelProperty(notes = "Grant Type", example = "refresh_token")
    private String grantType;

}
