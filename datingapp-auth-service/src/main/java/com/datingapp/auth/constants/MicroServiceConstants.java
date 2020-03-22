package com.datingapp.auth.constants;

/**
 * Datingapp on 19.03.2020
 *
 * @author volkanulutas
 */
public class MicroServiceConstants {

    public static final String LOGIN_MICROSERVICE = "/datingapp-login-service/api/login";

    public static final String ADMIN_MICROSERVICE = "datingapp-auth-demo";
    public static final String BASE_API = "/api";

    public interface AdminMicroServiceConstants {
        String FETCH_ADMIN_BY_USERNAME = "/fetch-admin/{username}";
    }
}
