package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static herokuapp_smoketest.S1_Post.bookingId;
import static io.restassured.RestAssured.given;

public class S3_Get extends HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/{id}
    When
        Send the get request
    Then
        Status Code should be 200
    And
        Response body should be
        {
            "firstname" : "Mark",
            "lastname" : "Twain",
            "totalprice" : 555,
            "depositpaid" : false,
            "bookingdates" : {
                "checkin" : "2023-01-01",
                "checkout" : "2024-01-01"
            },
            "additionalneeds" : "Extra Pillow"
         }

     */

    @Test
    public void get01() {
        //Set the url
        spec.pathParams("first","booking","second",bookingId);
        //Set the expected data

        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2023-01-01","2024-01-01");
        BookingPojo expectedData = new BookingPojo("Mark","Twain",555,false,bookingDatesPojo,"Extra Pillow");
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();
    }
}