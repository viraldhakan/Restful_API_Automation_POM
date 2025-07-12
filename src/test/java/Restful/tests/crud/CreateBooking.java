package Restful.tests.crud;

import Restful.endpoints.APIConstants;
import Restful.tests.base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.ITestContext;
import org.testng.annotations.Test;


public class CreateBooking extends BaseTest {

    @Owner("Viral Dhakan")
    @Description("Verify booking created successfully")
    @Test(groups = "CRUD")
    public void testCreateBooking(ITestContext iTestContext) throws JsonProcessingException {

        requestSpecification.basePath(APIConstants.Create_Booking_URL);

        response = RestAssured.given().spec(requestSpecification)
                .when()
                .body(payloadManager.CreatePayload())
                .post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


        jsonPath = JsonPath.from(response.asString());
        String bookingID = jsonPath.getString("bookingid");
        iTestContext.setAttribute("bookingid",jsonPath.getString("bookingid"));

        System.out.println("Created Booking ID :- " + bookingID);

    }
}
