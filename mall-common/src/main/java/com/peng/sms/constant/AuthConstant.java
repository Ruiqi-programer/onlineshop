package com.peng.sms.constant;

/**
 * Constants related to authentication and authorization
 */
public interface AuthConstant {

    /**
     * Prefix for storing authorities in JWT
     */
    String AUTHORITY_PREFIX = "ROLE_";

    /**
     * JWT claim name for storing authorities
     */
    String AUTHORITY_CLAIM_NAME = "authorities";

    /**
     * Client ID for backend management
     */
    String ADMIN_CLIENT_ID = "admin-app";

    /**
     * Client ID for frontend portal
     */
    String PORTAL_CLIENT_ID = "portal-app";

    /**
     * URL pattern for backend management APIs
     */
    String ADMIN_URL_PATTERN = "/mall-admin/**";

    /**
     * Redis cache key for authority rules (path -> resource)
     */
    String PATH_RESOURCE_MAP = "auth:pathResourceMap";

    /**
     * HTTP request header for authentication token
     */
    String JWT_TOKEN_HEADER = "Authorization";

    /**
     * Prefix for JWT token
     */
    String JWT_TOKEN_PREFIX = "Bearer ";

    /**
     * HTTP request header for user information
     */
    String USER_TOKEN_HEADER = "user";

    /**
     * Member information stored in sa-token session
     */
    String STP_MEMBER_INFO = "memberInfo";

    /**
     * Backend admin information stored in sa-token session
     */
    String STP_ADMIN_INFO = "adminInfo";

}
