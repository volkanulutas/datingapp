package com.datingapp.auth.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Datingapp on 19.03.2020
 *
 * @author volkanulutas
 */
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    private String secretKey;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
