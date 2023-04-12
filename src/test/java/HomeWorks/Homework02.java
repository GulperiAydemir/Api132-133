package HomeWorks;

import base_urls.RegresBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Homework02 extends RegresBaseUrl {
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
    public void homeWork2(){
        //Set the url
        spec.pathParams("first","users","second",23);
        //Send request get response

       Response response= given().spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();

       //
       response.
               then().
               statusCode(404).
               statusLine("HTTP/1.1 404 Not Found").header("server","cloudflare");

//               assertFalse(response.getBody().asString().isEmpty());
//               assertEquals("cloudflare", response.getHeader("Server"));

    }
}
