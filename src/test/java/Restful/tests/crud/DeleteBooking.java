package Restful.tests.crud;

import Restful.endpoints.APIConstants;
import Restful.tests.base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteBooking extends BaseTest {

    @Owner("Viral Dhakan")
    @Description("Verify booking delete successfully")
    @Test(groups = "CRUD")
    public void testDeleteBooking(ITestContext iTestContext) throws JsonProcessingException {

        String token = getToken();
        String bookingID = (String) iTestContext.getAttribute("bookingid");

        requestSpecification.basePath(APIConstants.Delete_Booking_URL + "/" + bookingID)
                .cookie("token", token);

        response = RestAssured
                .given().spec(requestSpecification)
                .when()
                .delete();

        validatableResponse = response.then().log().body();
        validatableResponse.statusCode(201);

        System.out.println("Deleted Booking Id :-" + bookingID);

    }
}
