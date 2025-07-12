package Restful.actions;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class AssertActions {

    public void verifyStatusCode(Response response){

        assertEquals(String.valueOf(response.getStatusCode())
                .startsWith("20"),true,"Value of status code is " + response.getStatusCode());
    }
}
