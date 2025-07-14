package Restful.tests.integrationtests;

import Restful.actions.AssertActions;
import Restful.endpoints.APIConstants;
import Restful.payload.Booking;
import Restful.tests.base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class IntegrationTest extends BaseTest {

    String token;

    @Owner("Viral Dhakan")
    @Description("Verify the Booking is Created or not")
    @Test
    public void testCreateBooking(ITestContext iTestContext) throws JsonProcessingException {

        if (requestSpecification == null) {
            System.out.println("Request Specification is Null");
        } else {
            requestSpecification.basePath(Restful.endpoints.APIConstants.Create_Booking_URL);

            response = RestAssured
                    .given().spec(requestSpecification)
                    .when()
                    .body(payloadManager.CreatePayload())
                    .post();

            validatableResponse = response.then().log().all();
            validatableResponse.statusCode(200);

            jsonPath = JsonPath.from(response.asString());
            String bookingID = jsonPath.getString("bookingid");

            iTestContext.setAttribute("bookingid", jsonPath.getString("bookingid"));
            System.out.println("Booking ID :- " + bookingID);

        }
    }

    @Owner("Viral Dhakan")
    @Description("Verify a booking is update successfully")
    @Test(dependsOnMethods = "testCreateBooking")
    public void testCreateAndUpdateBooking(ITestContext iTestContext) throws JsonProcessingException {

        token = getToken();

        requestSpecification.basePath(APIConstants.Update_Booking_URL + "/" + (String) iTestContext.getAttribute("bookingid"))
                .cookie("token", token);

        response = RestAssured
                .given().spec(requestSpecification)
                .when()
                .body(payloadManager.UpdatePayload())
                .put();

        validatableResponse = response.then().log().body();
        validatableResponse.body("firstname", Matchers.is("Rajiv"));

        System.out.println("Booking ID:- " + iTestContext.getAttribute("bookingid"));

        Booking updatebooking = response.as(Booking.class);

        AssertActions assertActions1 = new AssertActions();
        assertActions1.verifyStatusCode(response);
        assertActions1.verifyResponseBody(updatebooking.getFirstname(),"Rajiv","Verify a firstname is Rajiv");

    }

    @Owner("Viral Dhakan")
    @Description("Verify a booking is deleted successfully")
    @Test(dependsOnMethods = "testCreateAndUpdateBooking")
    public void testDeleteCreatedBooking(ITestContext iTestContext) {

        requestSpecification
                .basePath(Restful.endpoints.APIConstants.Update_Booking_URL + "/" + (String) iTestContext.getAttribute("bookingid"))
                .cookie("token", token);

        response = RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .delete();

        validatableResponse = response.then().log().body();
        validatableResponse.statusCode(201);

        System.out.println("Booking ID:- " + iTestContext.getAttribute("bookingid"));

    }
}
