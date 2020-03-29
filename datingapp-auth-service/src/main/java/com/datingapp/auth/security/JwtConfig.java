package com.datingapp.auth.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Component
public class JwtConfig {

   // Spring doesn't inject/autowire to "static" fields.
   // Link: https://stackoverflow.com/a/6897406
   @Value("${security.jwt.uri:/auth/**}")
   private String Uri;

   @Value("${security.jwt.header:Authorization}")
   private String header;

   @Value("${security.jwt.prefix:Bearer }")
   private String prefix;

   @Value("${security.jwt.expiration:#{24*60*60}}")
   private int validityInMilliseconds;

   @Value("${security.jwt.secret:JwtSecretKey}")
   private String secretKey;

   // In case you want to use plain getters instead of lombok.
   public String getUri() {
       return Uri;
   }

   public String getHeader() {
       return header;
   }

   public String getPrefix() {
       return prefix;
   }

   public int getValidityInMilliseconds() {
       return validityInMilliseconds;
   }

   public String getSecretKey() {
       return secretKey;
   }

   @Override
   public String toString() {
      return "JwtConfig{" +
              "Uri='" + Uri + '\'' +
              ", header='" + header + '\'' +
              ", prefix='" + prefix + '\'' +
              ", expiration=" + validityInMilliseconds +
              ", secret='" + secretKey + '\'' +
              '}';
   }
}
