package com.spring.springsecurityjwt.model;
/*
 * author: Sadik Hassan
 * created: 2:50 pm, 02/10/2022
 */

public class Authentication {
     private String username;
    private String password;

    public Authentication(){}
    public Authentication(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
