package TollCore;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static TollCore.Header.setHeader;
import static TollCore.ReqBody.requestBodyLoginFail;
import static TollCore.ReqBody.requestBodyLoginSuccess;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class runTest {
    private static String EmployeeId;
    private static String Password;
//Login thành công
    public static void LoginSuccess () {
        RestAssured.baseURI = GlobalContrains.BASE_URI_CORECTT;
            RequestSpecification request = given().log().all()
                .headers(setHeader())
                .when()
                .body(requestBodyLoginSuccess(EmployeeId, Password).toString());
        Response response = request.when().post(endpoint.EP_TOKEN_CORECTT);
        //System.out.println(response.getBody().asString());
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("EmployeeId", equalTo("040001"));
        String token = response.jsonPath().getString("JwtToken");
        System.out.println(token);
    }
//Login nhập sai username/pass
    public static void LoginFailure () {
        RestAssured.baseURI = GlobalContrains.BASE_URI_CORECTT;
        RequestSpecification request = given().log().all()
                .headers(setHeader())
                .when()
                .body(requestBodyLoginFail(EmployeeId, Password).toString());
        Response response = request.when().post(endpoint.EP_TOKEN_CORECTT);
        System.out.println(response.getBody().asString());
        response.then().assertThat().statusCode(401);
    }
}
