package com.bfly.management.model.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResult<T> {
  private String code;
  private String msg;
  private T result;

  public ApiResult(Enum<? extends EnumMapperType> en) {
    EnumMapperType enumMapperType = (EnumMapperType) en;
    this.code = enumMapperType.getCode();
    this.msg = enumMapperType.getMsg();
  }

  public ApiResult(Enum<? extends EnumMapperType> en, T result) {
    EnumMapperType enumMapperType = (EnumMapperType) en;
    this.code = enumMapperType.getCode();
    this.msg = enumMapperType.getMsg();
    this.result = result;
  }

  public ApiResult(Enum<? extends EnumMapperType> en, String msg, T result) {
    EnumMapperType enumMapperType = (EnumMapperType) en;
    this.code = enumMapperType.getCode();
    this.msg = msg;
    this.result = result;
  }
}