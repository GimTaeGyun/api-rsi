package com.bfly.management.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserDto {

  private String username;
  
  private String password;
  @NotNull
  private UserRole userRole;
  
  @JsonIgnore
  private int status;

  @JsonIgnore
  private String statusInfo;

}
