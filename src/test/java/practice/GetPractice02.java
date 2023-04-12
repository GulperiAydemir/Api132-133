package practice;

import base_urls.PetStoreBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;
  /*
          Given
          https://petstore.swagger.io/v2/pet/findByStatus?status=available
          When
          User sens Get request
          Then
          Assert that number of pets whose status is "available" is more than 100
          */

public class GetPractice02 extends PetStoreBaseUrl {

    @Test
    public void getPractice02(){

        //Set the Url

        spec.pathParams("first","pet","second","findByStatus").
                queryParam("status","available");

        //Set the Expected Data

        //Send the request Get the Response

        Response response=given(spec).get("/{first}/{second}");
        response.prettyPrint();


        //Do Assert

        JsonPath jsonPath=new JsonPath(response.toString());
        System.out.println("jsonPath = " + jsonPath);

        int availablePetNumber=response.jsonPath().getList("").size();

        System.out.println("availablePetNumber = " + availablePetNumber);

       assertTrue(availablePetNumber>100);

    }

}
