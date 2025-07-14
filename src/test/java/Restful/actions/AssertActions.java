package Restful.actions;

import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertActions {

    public void verifyStatusCode(Response response) {

        int statusCode = response.getStatusCode();

        assertThat(statusCode)
                .withFailMessage("Expected status code to be 2xx but was", statusCode)
                .isBetween(200, 299);
    }

    public void verifyResponseBody(String actual, String expected, String description) {

        assertThat(actual)
                .as(description)
                .isEqualTo(expected);
    }

}
