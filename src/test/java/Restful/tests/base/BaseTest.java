package Restful.tests.base;

import Restful.actions.AssertActions;
import Restful.endpoints.APIConstants;
import Restful.module.PayloadManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;


    @BeforeMethod
    public void setUpConfig() {

        payloadManager = new PayloadManager();
        assertActions = new AssertActions();

        requestSpecification = RestAssured.given()
                .baseUri(APIConstants.BaseURL)
                .contentType(ContentType.JSON);
    }

    public String getToken() throws JsonProcessingException {

        requestSpecification = RestAssured.given()
                .baseUri(Restful.endpoints.APIConstants.BaseURL)
                .basePath("/auth")
                .contentType(ContentType.JSON);

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        response = requestSpecification.contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post();

        jsonPath = new JsonPath(response.asString());
        return jsonPath.getString("token");
    }


    @AfterMethod
    public void tearDown() {
        System.out.println("End!!");
    }
}
