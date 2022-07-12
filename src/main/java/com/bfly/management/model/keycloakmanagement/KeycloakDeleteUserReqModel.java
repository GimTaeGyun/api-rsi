package com.bfly.management.model.keycloakmanagement;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class KeycloakDeleteUserReqModel {

  @ApiModelProperty(notes = "User ID", example = "testUser")
  private String userId;

  @ApiModelProperty(notes = "Admin Id", example = "test")
  private String adminId;
  
  @ApiModelProperty(notes = "Admin Pw", example = "test")
  private String adminPw;

  @ApiModelProperty(notes = "Client ID", example = "ApplicationClient")
  private String clientId;

  @ApiModelProperty(notes = "Realm Name", example = "ManageMentAPI")
  private String realm;

  @ApiModelProperty(notes = "Authentication Url", example = "http://192.168.10.198:8080/auth")
  private String authServerUrl;
  
  
  @ApiModelProperty(notes = "Client Secret", example = "C83UaObpMgTl66o8eaCbeuL9y7qHCvhr")
  private String clientSecret;

}
