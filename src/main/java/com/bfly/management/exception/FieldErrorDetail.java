package com.bfly.management.exception;

import org.springframework.validation.FieldError;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FieldErrorDetail {
   private String field;
   private String message;

   public static FieldErrorDetail create(FieldError fieldError) {
      return new FieldErrorDetail(fieldError.getField(), fieldError.getDefaultMessage());
   }
}