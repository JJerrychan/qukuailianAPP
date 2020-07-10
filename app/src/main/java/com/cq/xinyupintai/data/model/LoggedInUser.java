package com.cq.xinyupintai.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 * 这是as自带生成的user类
 */
public class LoggedInUser {

    private String userId;
    private String displayName;

    public LoggedInUser(String userId, String displayName) {
        this.userId = userId;
        this.displayName = displayName;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }
}