package com.toskey.cube.cloud.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * AuthorizationServerProperties
 *
 * @author lis
 * @version 1.0
 * @description TODO
 * @date 2024/6/14 10:34
 */
@ConfigurationProperties("cube.authorization.server")
public class AuthorizationServerProperties {

    private String[] ignorePaths = {"/token/**", "/login/**", "/error"};

    private String loginEntryPoint;

    private String issuerUrl;

    private List<String> corsUrls = new ArrayList<>();

    public String[] getIgnorePaths() {
        return ignorePaths;
    }

    public void setIgnorePaths(String[] ignorePaths) {
        this.ignorePaths = ignorePaths;
    }

    public String getLoginEntryPoint() {
        return loginEntryPoint;
    }

    public void setLoginEntryPoint(String loginEntryPoint) {
        this.loginEntryPoint = loginEntryPoint;
    }

    public String getIssuerUrl() {
        return issuerUrl;
    }

    public void setIssuerUrl(String issuerUrl) {
        this.issuerUrl = issuerUrl;
    }

    public List<String> getCorsUrls() {
        return corsUrls;
    }

    public void setCorsUrls(List<String> corsUrls) {
        this.corsUrls = corsUrls;
    }
}
