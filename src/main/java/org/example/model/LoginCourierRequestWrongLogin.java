package org.example.model;

import org.apache.commons.lang3.RandomStringUtils;

public class LoginCourierRequestWrongLogin {


    public String login;
    public String password;

    public LoginCourierRequestWrongLogin(String password) {
        this.login = RandomStringUtils.randomAlphabetic(10);
        this.password = password;
    }


}
