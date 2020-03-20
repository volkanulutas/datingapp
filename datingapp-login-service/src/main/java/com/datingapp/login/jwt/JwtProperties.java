package com.datingapp.login.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Datingapp on 20.03.2020
 *
 * @author volkanulutas
 */
@ConfigurationProperties(prefix = "jwt")
@Configuration
public class JwtProperties {

    private String secretKey;

    private long validityInMilliseconds;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public long getValidityInMilliseconds() {
        return validityInMilliseconds;
    }

    public void setValidityInMilliseconds(long validityInMilliseconds) {
        this.validityInMilliseconds = validityInMilliseconds;
    }
}
