import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.notNullValue;

public class getOrderListTest {
    @Before
    public void setup(){
        RestAssured.baseURI="http://qa-scooter.praktikum-services.ru";
    }

    @Test
    public void getOrderListTest(){
        given().get("/api/v1/orders")
                .then()
                .assertThat().statusCode(200)
                .and()
                .body("orders", notNullValue());
    }

}
