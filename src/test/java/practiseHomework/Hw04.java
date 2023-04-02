package practiseHomework;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Hw04 extends HerOkuAppBaseUrl {
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
    public void Hw04(){

        spec.pathParam("first","booking").
                queryParams("firstname","Josh","lastname","Allen");

        Response response=given().spec(spec).get("/{first}");
        response.prettyPrint();


        assertEquals(200,response.statusCode());

        Assert.assertTrue(response.asString().contains("booking"));







    }


}
