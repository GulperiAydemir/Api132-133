package HomeWorks;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class HomeWork04 extends HerOkuAppBaseUrl {
    //Homework4:


 /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Brandon&lastname=Wilson
        When
            User sends get request to the URL
        Then
            Status code is 200
        And
            Among the data there should be someone whose firstname is "Brandon" and lastname is "Wilson"

 */

    @Test
    public void homeWork04(){

        //Set the URL

        spec.pathParam("first","booking").
        queryParams("firstname","John","lastname","Smith");

        //Send request and get the response

        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        //Do Assertion

        assertEquals(200, response.statusCode());
        Assert.assertTrue(response.asString().contains("booking"));



    }

}
