import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.example.client.OrderApiClient;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetOrderListTest {
    OrderApiClient orderApiClient;

    @Before
    public void setup(){
        RestAssured.baseURI="http://qa-scooter.praktikum-services.ru";
        orderApiClient= new OrderApiClient();
    }

    @Test
    @DisplayName("Get order list")
    @Description("Проверка формирования списка заказов")
    public void getOrderListTest(){
        orderApiClient.getOrderList()
                .then()
                .assertThat().statusCode(200)
                .and()
                .body("orders", notNullValue());
    }

}
