package Restful.tests.crud;

import Restful.endpoints.APIConstants;
import Restful.tests.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;


public class GetBooking extends BaseTest {

    @Owner("Viral Dhakan")
    @Description("Verify booking get successfully")
    @Test(groups = "CRUD")
    public void testGetBooking(ITestContext iTestContext) {

        String bookingID = (String) iTestContext.getAttribute("bookingid");

        requestSpecification.basePath(APIConstants.Get_Booking_URL + "/" + bookingID);

        response = RestAssured
                .given().spec(requestSpecification)
                .when()
                .get();

        validatableResponse = response.then().log().body();
        validatableResponse.statusCode(200);

        System.out.println("Get Booking ID :- " + bookingID);
    }
}
