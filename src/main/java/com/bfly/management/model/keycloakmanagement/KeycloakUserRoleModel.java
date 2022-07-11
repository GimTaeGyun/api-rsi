package com.bfly.management.model.keycloakmanagement;

import java.util.Arrays;

import com.bfly.management.exception.BusinessException;
import com.bfly.management.model.common.ApiCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum  KeycloakUserRoleModel {
    ADMIN("관리자"),
    USER("사용자");


    private final String title;

    public static KeycloakUserRoleModel of(String title) {
        return Arrays.stream(values())
                .filter(v -> v.getTitle().equals(title))
                .findFirst().orElseThrow(() -> new BusinessException(ApiCode.API_USER_NOT_VALID_FAIL));
    }

    public String getCode() {
        return name();
    }
}
