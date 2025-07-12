package Restful.tests.crud;

import Restful.endpoints.APIConstants;
import Restful.tests.base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class UpdateBooking extends BaseTest {


    @Owner("Viral Dhakan")
    @Description("Verify booking update successfully")
    @Test(groups = "CRUD")
    public void testUpdateBooking(ITestContext iTestContext) throws JsonProcessingException {

        String token = getToken();
        String bookingID = (String) iTestContext.getAttribute("bookingid");

        requestSpecification.basePath(APIConstants.Update_Booking_URL + "/" + bookingID)
                .cookie("token", token);

        response = RestAssured
                .given().spec(requestSpecification)
                .when()
                .body(payloadManager.UpdatePayload()).put();

        validatableResponse = response.then().log().body();
        validatableResponse.statusCode(200);

        System.out.println("Updated Booking ID :-" + bookingID);

    }

}
