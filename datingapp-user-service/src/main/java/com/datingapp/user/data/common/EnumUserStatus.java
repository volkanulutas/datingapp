package com.datingapp.user.data.common;

import lombok.Getter;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Getter
public enum EnumUserStatus {
    BLOCKED("Blocked User by Application"),
    BLOCKED_BY_LOGIN_ATTEMPT("Blocked User by login attempt"),
    INACTIVE("Inactive User"),
    ONLINE("Online User"),
    OFFLINE("Offline User");

    private String value;

    EnumUserStatus(String value) {
        this.value = value;
    }
}
