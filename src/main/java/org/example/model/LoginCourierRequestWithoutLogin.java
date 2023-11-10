package org.example.model;

public class LoginCourierRequestWithoutLogin {

    public String login;
    public String password;

    public LoginCourierRequestWithoutLogin(String password) {
        this.login = null;
        this.password = password;
    }
}
