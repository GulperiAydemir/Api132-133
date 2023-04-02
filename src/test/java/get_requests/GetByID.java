package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetByID extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/246
        When
            I send GET Request to the url
        Then
            Response body should be like that;
           {
    "firstname": "Josh",
    "lastname": "Allen",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "midnight snack"
}

     */
    @Test
    public void get09(){

        //Set the URL

        spec.pathParams("first","booking","second",24);

     //Send the request get the response

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        response.then().body("firstname", equalTo("Josh"),
                "lastname", equalTo("Allen"),
                "totalprice", equalTo(111),
                "depositpaid", equalTo(true),
                "bookingdates.checkin", equalTo("2018-01-01"),
                "bookingdates.checkout", equalTo("2019-01-01"),
                "additionalneeds", equalTo( "midnight snack"));





    }
}
