package org.example.model;

import org.apache.commons.lang3.RandomStringUtils;

public class CourierGenerator {
    public static CreateCourierRequest getRandomCourier(){
        String login= RandomStringUtils.randomAlphabetic(10);
        String password=RandomStringUtils.randomAlphabetic(10);
        String firstName=RandomStringUtils.randomAlphabetic(10);

        return new CreateCourierRequest(login, password, firstName);

    }
}
