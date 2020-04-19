package com.datingapp.common;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created on 15.04.2020
 * <p>
 * Only one property 'datingapp.security.jwt.secret' is mandatory.
 *
 * @author volkanulutas
 */
@Getter
@ToString
public class JwtAuthenticationConfig {

    @Value("${datingapp.security.jwt.url:/login}")
    private String url;

    @Value("${datingapp.security.jwt.header:Authorization}")
    private String header;

    @Value("${datingapp.security.jwt.prefix:Bearer}")
    private String prefix;

    @Value("${datingapp.security.jwt.expiration:#{24*60*60}}")
    private int expiration; // default 24 hours

    @Value("${datingapp.security.jwt.secret}")
    private String secret;
}
