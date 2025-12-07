package com.peng.sms.util;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.listener.SaTokenEventCenter;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.session.TokenSign;
import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpLogic;
import lombok.Getter;

import java.util.List;

/**
 * @author macrozheng
 * @description Utility class for frontend member login authentication
 * Copied from default StpUtil with changes to TYPE and stpLogic object
 * @github <a href="https://github.com/macrozheng">...</a>
 */
public class StpMemberUtil {

    private StpMemberUtil() {
    }

    /**
     * Type identifier for multi-account system
     */
    public static final String TYPE = "memberLogin";

    /**
     * Underlying StpLogic object
     * -- GETTER --
     * Get the current StpLogic object
     */
    @Getter
    public static StpLogic stpLogic = new StpLogicJwtForSimple(TYPE);

    /**
     * Get the login type of the current StpLogic
     *
     * @return login type
     */
    public static String getLoginType() {
        return stpLogic.getLoginType();
    }

    /**
     * Safely reset the StpLogic object
     *
     * <br> 1. Replace the StpLogic object for this account
     * <br> 2. Put it into the global StpLogic collection
     * <br> 3. Trigger an event for logging
     *
     * @param newStpLogic new StpLogic object
     */
    public static void setStpLogic(StpLogic newStpLogic) {
        stpLogic = newStpLogic;
        SaManager.putStpLogic(newStpLogic);
        SaTokenEventCenter.doSetStpLogic(stpLogic);
    }

    // ------------------- Token related operations -------------------

    /**
     * Get the token name.
     * This name is used in cookie, request parameter, and token storage key prefix
     *
     * @return token name
     */
    public static String getTokenName() {
        return stpLogic.getTokenName();
    }

    /**
     * Set the token value in the current session
     *
     * @param tokenValue token value
     */
    public static void setTokenValue(String tokenValue) {
        stpLogic.setTokenValue(tokenValue);
    }

    /**
     * Set the token value with a cookie timeout
     *
     * @param tokenValue    token value
     * @param cookieTimeout cookie timeout in seconds
     */
    public static void setTokenValue(String tokenValue, int cookieTimeout) {
        stpLogic.setTokenValue(tokenValue, cookieTimeout);
    }

    /**
     * Set the token value with a login model
     *
     * @param tokenValue token value
     * @param loginModel login parameters
     */
    public static void setTokenValue(String tokenValue, SaLoginModel loginModel) {
        stpLogic.setTokenValue(tokenValue, loginModel);
    }

    /**
     * Get the token value from the current request
     *
     * @return token value
     */
    public static String getTokenValue() {
        return stpLogic.getTokenValue();
    }

    /**
     * Get the token value from the current request without cutting prefix
     *
     * @return token value
     */
    public static String getTokenValueNotCut() {
        return stpLogic.getTokenValueNotCut();
    }

    /**
     * Get token information of the current session
     *
     * @return token info
     */
    public static SaTokenInfo getTokenInfo() {
        return stpLogic.getTokenInfo();
    }

    // ------------------- Login related operations -------------------

    /**
     * Login with account id
     *
     * @param id account id (long, int, or String recommended)
     */
    public static void login(Object id) {
        stpLogic.login(id);
    }

    /**
     * Login with account id and device type
     *
     * @param id     account id
     * @param device device type
     */
    public static void login(Object id, String device) {
        stpLogic.login(id, device);
    }

    /**
     * Login with account id and remember-me option
     *
     * @param id              account id
     * @param isLastingCookie whether to remember login
     */
    public static void login(Object id, boolean isLastingCookie) {
        stpLogic.login(id, isLastingCookie);
    }

    /**
     * Login with account id and token timeout
     *
     * @param id      account id
     * @param timeout token timeout in seconds
     */
    public static void login(Object id, long timeout) {
        stpLogic.login(id, timeout);
    }

    /**
     * Login with full login model
     *
     * @param id         account id
     * @param loginModel login parameters
     */
    public static void login(Object id, SaLoginModel loginModel) {
        stpLogic.login(id, loginModel);
    }

    /**
     * Check if the current account is logged in
     *
     * @return true if logged in
     */
    public static boolean isLogin() {
        return stpLogic.isLogin();
    }

    /**
     * Get the current logged-in account id
     *
     * @return account id
     */
    public static Object getLoginId() {
        return stpLogic.getLoginId();
    }

    /**
     * Get the current logged-in account id in long type
     *
     * @return account id
     */
    public static long getLoginIdAsLong() {
        return stpLogic.getLoginIdAsLong();
    }

    /**
     * Get the current logged-in account id in int type
     *
     * @return account id
     */
    public static int getLoginIdAsInt() {
        return stpLogic.getLoginIdAsInt();
    }

    /**
     * Get the current logged-in account id in String type
     *
     * @return account id
     */
    public static String getLoginIdAsString() {
        return stpLogic.getLoginIdAsString();
    }

    /**
     * Logout the current account
     */
    public static void logout() {
        stpLogic.logout();
    }

    /**
     * Logout the current account on a specific device
     *
     * @param device device type
     */
    public static void logoutByDevice(String device) {
        stpLogic.logout(device);
    }

    /**
     * Logout all devices of the current account
     */
    public static void logoutAll() {
        stpLogic.logout();
    }

    // ------------------- Session related operations -------------------

    /**
     * Get session of current account
     *
     * @return session
     */
    public static SaSession getSession() {
        return stpLogic.getSession();
    }

    /**
     * Get session by session id
     *
     * @param sessionId session id
     * @return session
     */
    public static SaSession getSessionById(String sessionId) {
        return stpLogic.getSessionBySessionId(sessionId);
    }

    /**
     * Get session of specific account
     *
     * @param loginId account id
     * @return session
     */
    public static SaSession getSession(Object loginId) {
        return stpLogic.getSessionByLoginId(loginId);
    }


    // ------------------- Permission related operations -------------------

    /**
     * Check if the current account has a permission
     *
     * @param permission permission string
     */
    public static void checkPermission(String permission) {
        stpLogic.checkPermission(permission);
    }


    /**
     * Check if the current account has a role
     *
     * @param role role string
     */
    public static void checkRole(String role) {
        stpLogic.checkRole(role);
    }


    /**
     * Get permission list of the current account
     *
     * @return list of permissions
     */
    public static List<String> getPermissionList() {
        return stpLogic.getPermissionList();
    }

    /**
     * Get role list of the current account
     *
     * @return list of roles
     */
    public static List<String> getRoleList() {
        return stpLogic.getRoleList();
    }

    // ------------------- Token signature related operations -------------------

    /**
     * Get TokenSign object by token value
     *
     * @param tokenValue token value
     * @return TokenSign
     */
    public static TokenSign getTokenSign(String tokenValue) {
        return stpLogic.getSession().getTokenSign(tokenValue);
    }

}
