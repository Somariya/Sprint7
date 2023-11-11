package org.example.model;

import org.apache.commons.lang3.RandomStringUtils;

public class CreateCourierRequest {
    public String login;
    public String password;
    public String firstName;

    public CreateCourierRequest(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    public CreateCourierRequest(){

    }


}
