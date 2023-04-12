package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Get09Review extends JsonPlaceHolderBaseUrl {


     /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false

            }
     */

    @Test
    public void get09(){

        //Set the Url

        spec.pathParams("first","todos","second",2);

        //Set the Expected Data

        Map<String,Object> expectedData= new JsonPlaceHolderTestData().expectedDataMapMethod(1,"quis ut nam facilis et officia qui",false);
        expectedData.put("via","1.1 vegur");
        expectedData.put("server","cloudflare");

        System.out.println("expectedData = " + expectedData);

     //Send the request get the Response

        Response response=given(spec).get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion

        Map<String,Object> acceptedData=response.as(HashMap.class);
        System.out.println("acceptedData = " + acceptedData);

        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.get("completed"),acceptedData.get("completed"));
        Assert.assertEquals(expectedData.get("Via"),acceptedData.get("Via"));
        Assert.assertEquals(expectedData.get("Server"),acceptedData.get("Server"));
        Assert.assertEquals(expectedData.get("userId"),acceptedData.get("userId"));
        Assert.assertEquals(expectedData.get("title"),acceptedData.get("title"));


    }

}

