package org.example.model;

import org.apache.commons.lang3.RandomStringUtils;

public class LoginCourierRequestWrongPassword {
    public String login;
    public String password;

    public LoginCourierRequestWrongPassword(String login) {
        this.login = login;
        this.password = RandomStringUtils.randomAlphabetic(10);
    }

}
