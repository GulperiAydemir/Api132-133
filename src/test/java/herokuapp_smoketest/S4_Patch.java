package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static herokuapp_smoketest.S1_Post.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class S4_Patch extends HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/{id}
    And
        {
        "firstname": "John",
        "lastname": "Doe"
        }
   When
        Send the patch request
   Then
        Status code should be 200
   And
        Body should be like:
        {
            "firstname" : "John",
            "lastname" : "Doe",
            "totalprice" : 555,
            "depositpaid" : false,
            "bookingdates" : {
                "checkin" : "2023-01-01",
                "checkout" : "2024-01-01"
            },
            "additionalneeds" : "Extra Pillow"
         }
     */

    @Test
    public void patchTest(){
        //Set the url
        spec.pathParams("first","booking","second",bookingId);

        Map<String,String> expectedData=new HashMap<>();
        expectedData.put("firstname" , "John");
        expectedData.put("lastname" , "Doe");

        //Send the request get the response

       Response response= given(spec).body(expectedData).patch("{first}/{second}");
       response.prettyPrint();

       //Do Assertion
       assertEquals(200,response.statusCode());
       assertEquals(expectedData.get("firstname"),response.jsonPath().getString("firstname"));
       assertEquals(expectedData.get("lastname"),response.jsonPath().getString("lastname"));


        //Do assertion
        //Map<String,Object> actualData = ObjectMapperUtils.convertJsonToJavaObject(response.asString(),HashMap.class);
        // System.out.println("actualData = " + actualData);
        //assertEquals(200,response.statusCode());
        //assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        //assertEquals(expectedData.get("lastname"), actualData.get("lastname"));






    }
}