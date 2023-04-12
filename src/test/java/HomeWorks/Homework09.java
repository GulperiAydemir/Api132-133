package HomeWorks;

import base_urls.PetStoreBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PetStorePojo;

import java.util.List;

import static io.restassured.RestAssured.given;

import static org.junit.Assert.assertTrue;

public class Homework09 extends PetStoreBaseUrl {

    //Using the https://petstore.swagger.io/ document, write an automation
    // test that finds the number of "pets" with a status of "available" and asserts
    // that those are more than 100.

    @Test
    public void homework09() {


        //Set the Url
        spec.pathParams("first", "pet", "second", "findByStatus").queryParam("status", "available");

        //Set the Expected Data

        //Send the request get the response
        Response response = given().spec(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion

        Assert.assertEquals(200,response.statusCode());
        JsonPath json=response.jsonPath();
        List<String> available=json.getList("status");
        System.out.println("status = " + available);

         Assert.assertTrue(available.size()>100);

        //Do assertion

//        assertEquals(200, response.statusCode());
//        JsonPath jsonPath = response.jsonPath();
//        List<String> available = jsonPath.getList("status");
//        System.out.println("available = " + available);
//        System.out.println("available = " + available.size());
//
//        assertTrue(available.size()>100);


    }
}
