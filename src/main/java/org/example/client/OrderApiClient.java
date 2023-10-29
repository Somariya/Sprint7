package org.example.client;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.example.model.CreateCourierRequest;
import org.example.model.CreateOrderRequest;
import org.example.model.CreateOrderResponse;

import static org.example.config.ConfigApp.BASE_URL;


public class OrderApiClient extends BaseApiClient {
    private static final String ORDER = "api/v1/orders";
    private static final String DELETE_ORDER = "api/v1/orders/cancel";

      public ValidatableResponse createOrder(CreateOrderRequest createOrderRequest) {
        return (ValidatableResponse) getPostSpec()
                .body(createOrderRequest)
                .when()
                .post(BASE_URL + ORDER);
    }

    public ValidatableResponse  deleteOrder(int trackId){
        CreateOrderResponse createOrderResponse=new CreateOrderResponse(trackId);
        return (ValidatableResponse) getPostSpec()
                .body(createOrderResponse)
                .when()
                .put(BASE_URL+DELETE_ORDER);
    }



}