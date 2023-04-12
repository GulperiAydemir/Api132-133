package get_requests;

import base_urls.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class Get07Review extends PetStoreBaseUrl {
     /*
    Given
        https://petstore.swagger.io/v2/pet/3467889
    When
         User send a GET request to the URL
    Then
        HTTP Status Code should be 200
    And
        Response content type is "application/json"
    And
        Response body should be like;
           {
            "id": 3467889,
            "category": {
                "id": 0,
                "name": "Bird"
            },
            "name": "Tweety",
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
    public void get07(){
        //Set the Url
        spec.pathParams("first","pet","second",3467889);
        //Set the expected Data

        //Send the request get the response
        Response response=given(spec).contentType(ContentType.JSON).get("/{first}/{second}");
        response.prettyPrint();

       //JsonPath jsonpath=response.jsonPath();
        //Do Assert

        SoftAssert softAssert=new SoftAssert();
        //softAssert.assertEquals(jsonpath.getInt("id"),"3467889","not found");
        softAssert.assertEquals("name","Tweety","not found");

    }

}
