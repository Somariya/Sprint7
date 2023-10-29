import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.example.client.CourierApiClient;
import org.example.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.example.model.CourierGenerator.getRandomCourier;
import static org.example.config.ConfigApp.BASE_URL;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class CourierTest {
    CreateCourierRequest createCourierRequest;
    LoginCourierRequest loginCourierRequest;
    CourierApiClient courierApiClient;

    @Before
    public void setup(){

        createCourierRequest = getRandomCourier();
        loginCourierRequest = new LoginCourierRequest(createCourierRequest.login, createCourierRequest.password);
        courierApiClient = new CourierApiClient();

    }

    @Test
    public void courierTest(){

        Response createResponse = courierApiClient.createCourier(createCourierRequest);
        assertEquals(SC_CREATED, createResponse.statusCode());
        CreateCourierResponse createCourierResponse = createResponse.as(CreateCourierResponse.class);
        assertTrue(createCourierResponse.ok);


        Response loginResponse = courierApiClient.loginCourier(loginCourierRequest);
        assertEquals(SC_OK, loginResponse.statusCode());
        LoginCourierResponse loginCourierResponse = loginResponse.as(LoginCourierResponse.class);
        assertNotNull(loginCourierResponse.id);

    }

    @After
    public void tearDown() {
        Integer resultLogin =
                courierApiClient.loginCourier(loginCourierRequest)
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.SC_OK)
                        .extract()
                        .path("id");

        courierApiClient.deleteCourier(resultLogin)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .path("id");
    }
}
