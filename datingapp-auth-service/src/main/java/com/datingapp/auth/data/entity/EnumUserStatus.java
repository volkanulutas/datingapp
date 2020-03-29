package com.datingapp.auth.data.entity;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public enum EnumUserStatus {
    BLOCKED("Blocked User by Application"),
    BLOCKED_BY_LOGIN_ATTEMPT("Blocked User by login attempt"),
    INACTIVE("Inactive User"),
    ONLINE("Online User"),
    OFFLINE("Offline User");

    private String value;

    EnumUserStatus(String value ) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
