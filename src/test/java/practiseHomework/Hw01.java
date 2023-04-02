package practiseHomework;

import base_urls.RegresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class Hw01 extends RegresBaseUrl {
     /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */


    @Test
    public void Hw01(){
        //Set the Url
        spec.pathParams("first","users","second",3);
        //send the request get the response
        Response response=given().log().all().spec(spec).contentType(JSON).get("/{first}/{second}");
        response.prettyPrint();

        //Do assert

       response.then().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");

//        Assert.assertEquals(200,response.getStatusCode());
//        Assert.assertEquals(JSON,response.contentType());
//        Assert.assertEquals("HTTP/1.1 200 OK",response.statusLine());

//        @Test
//        public void get01(){
//
//            String url = "https://reqres.in/api/users/3";
//            Response response1 = given().when().get(url);
//            //response.prettyPrint();
//
//            response1.
//                    then().
//                    statusCode(200).
//                    contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");



    }

}
