package com.udemy.models;

public class User {

    private String name;
    private String email;
    private String password;
    private String cookieName;
    private String cookieValue;
    private String UserLabel;

    public User() {}

    public User (String cookieName, String cookieValue) {
        this.cookieName = cookieName;
        this.cookieValue = cookieValue;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setUserLabel(String newUserLabel) {
        this.UserLabel = newUserLabel;
        return this;
    }

    public String getCookieValue() {
        return cookieValue;
    }

    public String getCookieName() {
        return cookieName;
    }

    public String getUserLabel() {
        return UserLabel;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

}