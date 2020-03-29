package com.datingapp.auth.security;

import com.datingapp.auth.constant.JWTConstants;
import com.datingapp.auth.data.dto.NetworkResponseDto;
import com.datingapp.auth.util.NetworkUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Component
public class JwtTokenProvider implements InitializingBean {

    @Autowired
    private JwtConfig jwtProperties;

    private String secretKey;

    @Override
    public void afterPropertiesSet() throws Exception {
        secretKey = Base64.getEncoder().encodeToString(jwtProperties.getSecretKey().getBytes());
    }

    public String createToken(Authentication auth, HttpServletRequest request) {
        NetworkResponseDto network = NetworkUtils.getDeviceAddresses.apply(request);

        return Jwts.builder()
                .setSubject(auth.getName())
                .claim("mac", network.getMacAddress())
                .claim("ip", network.getIpAddress())
                .claim("authorities", auth.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuer(JWTConstants.JWT_KEY)
                .setExpiration(calculateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    private Date calculateExpirationDate() {
        Date now = new Date();
        return new Date(now.getTime() + jwtProperties.getValidityInMilliseconds());
    }
}
