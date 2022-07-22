package com.bfly.management.model.keycloakmanagement;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class KeycloakCreateUserReqModel {

  @ApiModelProperty(notes = "User ID", example = "testUser")
  private String userId;

  // @ApiModelProperty(notes = "Admin Id", example = "test")
  // private String adminId;
  
  // @ApiModelProperty(notes = "Admin Pw", example = "test")
  // private String adminPw;

  // @ApiModelProperty(notes = "Client ID", example = "ApplicationClient")
  // private String clientId;

  // @ApiModelProperty(notes = "Realm Name", example = "ManageMentAPI")
  // private String realm;

  // @ApiModelProperty(notes = "Authentication Url", example = "http://192.168.10.198:8080/auth")
  // private String authServerUrl;
  
  // @ApiModelProperty(notes = "Client Secret", example = "C83UaObpMgTl66o8eaCbeuL9y7qHCvhr")
  // private String clientSecret;

  @ApiModelProperty(hidden=true)
  private String userPw;

  @ApiModelProperty(notes = "User Role")
  private KeycloakUserRoleModel roles;

  @ApiModelProperty(hidden=true)
  private int status;

  @ApiModelProperty(hidden=true)
  private String statusInfo;

  @ApiModelProperty(notes = "User Name", example = "홍길동")
  private String userNm;

  @ApiModelProperty(notes = "User E-Mail", example = "gildong@gmail.com")
  private String email;

}
