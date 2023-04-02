package practiseHomework;

import base_urls.RegresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anEmptyMap;

public class Hw02 extends RegresBaseUrl {

     /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty

     */


    @Test
    public void Hw02(){

        //Set the Url
        spec.pathParams("first","users","second",23);

        //Send the request Get the response

        Response response=given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion

        response.then().
                statusCode(404).
                statusLine("HTTP/1.1 404 Not Found").
                header("server","cloudflare").
                body("",anEmptyMap());








    }

}
