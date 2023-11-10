package org.example.model;

public class LoginCourierRequestWithoutPassword {
    public String login;
    public String password;


    public LoginCourierRequestWithoutPassword(String login) {
        this.login = login;
        this.password = null;
    }
}

