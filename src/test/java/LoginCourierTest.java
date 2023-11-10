import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.example.client.CourierApiClient;
import org.example.model.*;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.apache.http.HttpStatus.*;
import static org.example.model.CourierGenerator.getRandomCourier;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class LoginCourierTest {
    CreateCourierRequest createCourierRequest;
    LoginCourierRequest loginCourierRequest;
    CourierApiClient courierApiClient;
    LoginCourierRequestWithoutLogin loginCourierRequestWithoutLogin;
    LoginCourierRequestWithoutPassword loginCourierRequestWithoutPassword;
    LoginCourierRequestWrongLogin loginCourierRequestWrongLogin;
    LoginCourierRequestWrongPassword loginCourierRequestWrongPassword;

    @Before
    public void setup(){

        createCourierRequest = getRandomCourier();
        loginCourierRequest = new LoginCourierRequest(createCourierRequest.login, createCourierRequest.password);
        courierApiClient = new CourierApiClient();
        loginCourierRequestWithoutLogin = new LoginCourierRequestWithoutLogin(createCourierRequest.password);
        loginCourierRequestWithoutPassword = new LoginCourierRequestWithoutPassword(createCourierRequest.login);
        loginCourierRequestWrongLogin= new LoginCourierRequestWrongLogin(createCourierRequest.password);
        loginCourierRequestWrongPassword = new LoginCourierRequestWrongPassword(createCourierRequest.login);


    }

    @Test
    @DisplayName("Login courier")
    @Description("Проверка авторизации курьера")
    public void LoginCourierTest(){

        Response loginResponse = courierApiClient.loginCourier(loginCourierRequest);
        assertEquals(SC_OK, loginResponse.statusCode());
        LoginCourierResponse loginCourierResponse = loginResponse.as(LoginCourierResponse.class);
        assertNotNull(loginCourierResponse.trackId);

    }

    @Test
    @DisplayName("Login courier with no Login")
    @Description("Проверка авторизации курьером без логина")
    public void LoginCourierTestNoLogin(){

        Response loginResponse = courierApiClient.loginCourierNoLogin(loginCourierRequestWithoutLogin);
        assertEquals(SC_BAD_REQUEST, loginResponse.statusCode());

    }



    @Test
    @DisplayName("Login courier with wrong Login")
    @Description("Проверка авторизации курьером с неверным логином")
    public void LoginCourierTestWrongLogin(){

        Response loginResponse = courierApiClient.loginCourierWrongLogin(loginCourierRequestWrongLogin);
        assertEquals(SC_NOT_FOUND, loginResponse.statusCode());

    }

    @Test
    @DisplayName("Login courier with wrong Password")
    @Description("Проверка авторизации курьером с неверным паролем")
    public void LoginCourierTestWrongPassword(){

        Response loginResponse = courierApiClient.loginCourierWrongPassword(loginCourierRequestWrongPassword);
        assertEquals(SC_NOT_FOUND, loginResponse.statusCode());

    }




}
