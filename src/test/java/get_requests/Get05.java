package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

public class Get05 extends HerOkuAppBaseUrl{
    /*
       Given
           https://restful-booker.herokuapp.com/booking
       When
           User sends get request to the URL
       Then
           Status code is 200
     And
        Among the data there should be someone whose firstname is "John" and lastname is "Smith"
    */
    @Test
    public void get05(){
        //Set the URL
        spec.pathParam("first","booking").
                queryParams("firstname","John",
                        "lastname","Smith");

        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("{first}");
        response.prettyPrint();

        //Do Assertion

        //1st Way://DT
        response.then().statusCode(200).body("", hasSize(greaterThan(0)));//DT


        assertEquals(200, response.statusCode());
        assertTrue(response.asString().contains("bookingid"));






    }
}