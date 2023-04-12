package HomeWorks;

import base_urls.PetStoreBaseUrl;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.PetStoreTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Homework08 extends PetStoreBaseUrl {
    /*
   Type automation code to create a 'user' by using "https://petstore.swagger.io/v2"" documantation.
    {
    "id": 86,
    "category": {
        "id": 0,
        "name": "bird"
    },
    "name": "Twity",
    "photoUrls": [
        "string"
    ],
    "tags": [
        {
            "id": 0,
            "name": "string"
        }
    ],
    "status": "available"
}
   */

    @Test
    public void Test08(){

        //Set the Url
        spec.pathParam("first","pet").queryParam("id",86);

        //Set the expected data

        Map<String,String> catogoryMap=new PetStoreTestData().categoryMapMethod("bird");
        Map<String,Object> expectedData=new PetStoreTestData().expectedDataMapMethod(86,"Twity","available",catogoryMap);
        System.out.println("expectedData = " + expectedData);

        //Sent the request get the reponse
        Response response=given(spec).when().body(expectedData).contentType(ContentType.JSON).post("/{first}");
        response.prettyPrint();

        //Do Assertion

        Map<String,Object> actualData=response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        Assert.assertEquals(expectedData.get("id"),actualData.get("id"));
        Assert.assertEquals(expectedData.get("name"),actualData.get("name"));
        Assert.assertEquals(expectedData.get("status"),actualData.get("status"));
        Assert.assertEquals( ((Map)expectedData.get("category")).get("name") , ((Map)actualData.get("category")).get("name"));


    }

}
