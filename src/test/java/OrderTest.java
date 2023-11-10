import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.example.client.OrderApiClient;
import org.example.model.CreateOrderRequest;
import org.example.model.CreateOrderResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.example.model.OrderGenerator.randomOrder;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest {
    OrderApiClient orderApiClient;
    CreateOrderRequest createOrderRequest;

    private List<String> colour;

    private int trackId;


    @Before
    public void setup() {
        orderApiClient = new OrderApiClient();
    }

    public void OrderTest(List<String> colour) {
        this.colour = colour;
    }


    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {List.of("BLACK")},
                {List.of("GREY")},
                {List.of("GREY","BLACK")},
                {List.of()},
        };
    }



    @Test
    public void orderTest(){
        createOrderRequest=randomOrder();
        createOrderRequest.setColor(colour);
        ValidatableResponse response = (ValidatableResponse) orderApiClient.createOrder(createOrderRequest);
        trackId = response.extract().path("track");

        assertThat("Статус код неверный при создании заказа",
                response.extract().statusCode(), equalTo(SC_CREATED));
        assertThat("Неверное сообщение при создании заказа",
                response.extract().path("track"),instanceOf(Integer.class));



    }

    @After
    public void tearDown() {

        orderApiClient.deleteOrder(trackId);


    }
}