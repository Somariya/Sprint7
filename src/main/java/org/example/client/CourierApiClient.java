package org.example.client;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.model.CreateCourierRequest;
import org.example.model.LoginCourierRequest;

import static io.restassured.RestAssured.given;
import static org.example.config.ConfigApp.BASE_URL;

public class CourierApiClient extends BaseApiClient {
    public Response createCourier(CreateCourierRequest createCourierRequest) {
        return getPostSpec()
                .body(createCourierRequest)
                .when()
                .post(BASE_URL + "/api/v1/courier");
    }

        public Response loginCourier(LoginCourierRequest loginCourierRequest) {
            return getPostSpec()
                    .body(loginCourierRequest)
                    .when()
                    .post(BASE_URL + "/api/v1/courier/login");
    }
    public Response deleteCourier(int id) {
        return getPostSpec()
                .when()
                .delete(BASE_URL + "/api/v1/courier/" + id);
    }

}
