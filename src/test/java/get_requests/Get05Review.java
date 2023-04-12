package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class Get05Review extends HerOkuAppBaseUrl {
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
    protected void get05(){

        //Set the Url

        spec.pathParam("first","booking").
                queryParams("firstname","John","lastname","Smith");

        //Send the request Set the response
        Response response = given().spec(spec).when().get("{first}");

       response.prettyPrint();

       //Do Assertion

        //1.way

        response.then().statusCode(200).body("", hasSize(greaterThan(0)));

        //2.way
        Assert.assertEquals(200,response.statusCode());
        Assert.assertTrue(response.asString().contains("bookingid"));







    }

}
