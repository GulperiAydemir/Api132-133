package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static herokuapp_smoketest.S1_Post.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class S6_Get_Negative extends HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/{id}
    When
        Send get request
    Then
        Status code should be 404
    And
         Response body should be "Not Found"
     */

    @Test
    public void get02(){

        //Set the url
        spec.pathParams("first", "booking", "second", bookingId);

        //Set the expected data
        String expectedData = "Not Found";

        //Send the request get the response

        Response response=given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do Assertion

        assertEquals(404,response.statusCode());
        assertEquals(expectedData,response.asString());







    }
}