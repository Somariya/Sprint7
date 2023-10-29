package org.example.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;



public class OrderGenerator {
    public static CreateOrderRequest randomOrder() {

        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.setFirstName(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setLastName(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setAddress(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setMetroStation(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setPhone(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setRentTime(RandomUtils.nextInt(100,10));
        createOrderRequest.setDeliveryDate(String.valueOf(RandomUtils.nextInt(100,10)));
        createOrderRequest.setComment(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setColor(List.of(RandomStringUtils.randomAlphabetic(10)));

        return createOrderRequest;
    }
}
