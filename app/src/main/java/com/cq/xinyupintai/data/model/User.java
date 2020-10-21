package com.cq.xinyupintai.data.model;

/*
    所有可登录用户父类
 */
public class User {
    private String Login_name;      //登陆账号
    private String Password_hash;   //登陆密码的MD5摘要

    public String getLogin_name() {
        return Login_name;
    }

    public void setLogin_name(String login_name) {
        Login_name = login_name;
    }

    public String getPassword_hash() {
        return Password_hash;
    }

    public void setPassword_hash(String password_hash) {
        Password_hash = password_hash;
    }
}
