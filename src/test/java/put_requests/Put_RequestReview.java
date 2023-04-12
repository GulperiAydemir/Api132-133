package put_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class Put_RequestReview extends JsonPlaceHolderBaseUrl {
    /*
        Given
           1) https://jsonplaceholder.typicode.com/todos/198
           2) {
                 "userId": 21,
                 "title": "Wash the dishes",
                 "completed": false
               }
        When
         I send PUT Request to the Url
       Then
             Status code is 200
             And response body is like   {
                               "userId": 21,
                               "title": "Wash the dishes",
                               "completed": false
                              }
     */

    @Test
    public void put01(){

        //Set the Url

        spec.pathParams("first","todos","second",198);

        //Set the expected data

        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("userId",21);
        expectedData.put("title","Wash the dishes");
        expectedData.put("completed",false);
        System.out.println("expectedData = " + expectedData);

        //Send the request get the response

        Response response=given(spec).when().body(expectedData).put("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion

        Map<String,Object>actualData=response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.get("userId"),actualData.get("userId"));
        Assert.assertEquals(expectedData.get("title"),actualData.get("title"));
        Assert.assertEquals(expectedData.get("completed"),actualData.get("completed"));


    }

}
