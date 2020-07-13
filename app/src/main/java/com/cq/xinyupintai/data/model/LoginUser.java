package com.cq.xinyupintai.data.model;
/*
    所有可登录用户父类
 */
public class LoginUser {
    private int id;
    private String Username;
    private String Password;

    public LoginUser(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
