package api;

import endpoint.EndPoint;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import json.CreateOrderRequest;
import json.Orders;
//import java.io.File;
import static api.BaseSteps.getRequestSpec;

public class OrderApi {
    public static Response getIngredient(){
        return getRequestSpec()
                .when()
                .get(EndPoint.INGREDIENTS);
    }

    public static Response getOrders(Orders orders){
        return getRequestSpec()
                .body(orders)
                .when()
                .get(EndPoint.ORDER);
    }

    public static Response getOrdersWithToken(CreateOrderRequest orders, String accestoken){
        return getRequestSpec()
                .header("Authorization", accestoken)
                .body(orders)
                .when()
                .get(EndPoint.ORDER);
    }


    public Response getAllOrdersWithToken(String accessToken) {
        return getRequestSpec()
                .header("Authorization", accessToken)
                .when()
                .get(EndPoint.ORDER);
    }

    public Response getAllOrdersWithoutToken() {
        return getRequestSpec()
                .when()
                .get(EndPoint.ORDER);
    }

    public Response postAllOrdersWithToken(String accessToken) {
        return getRequestSpec()
                .header("Authorization", accessToken)
                .when()
                .post(EndPoint.ORDER);
    }

    public static Response postOrdersWithToken(CreateOrderRequest orders, String accestoken) {
        return getRequestSpec()
                .header("Authorization", accestoken)
                .body(orders)
                .when()
                .post(EndPoint.ORDER);
    }

    //  public static Response postOrdersWithToken(File orders){
    //      return getRequestSpec()
    //              .header("Content-type", "application/json")
    //              .body(orders)
    //              .when()
    //              .post(EndPoint.ORDER);
    //  }

}