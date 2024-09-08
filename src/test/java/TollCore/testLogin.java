package TollCore;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.equalTo;

public class testLogin {
    public static void main(String[] args)
    {
        RestAssured.baseURI = GlobalContrains.BASE_URI_CORECTT;
        RequestSpecification request = RestAssured.given().log().all()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body("{\"EmployeeId\": \"040001\",\n" +
                        "  \"Password\": \"1\"}");
        Response response = request.when().post(endpoint.EP_TOKEN_CORECTT);
       // System.out.println(response.getBody().asString());
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("EmployeeId", equalTo("040001"));
        String token = response.jsonPath().getString("JwtToken");
        System.out.println(token);
    }
}
