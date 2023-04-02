package get_requests;

import base_urls.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Review extends PetStoreBaseUrl {
    /*

    Given
    https://petstore.swagger.io/v2/pet/55
    When
    User send a GET request to the URL
    Then
    HTTP Status Code should be200
    And
    Response content type is "application/json"
    And
    Response body should be like
   {  "id": 55,
    "category": {
        "id": 0,
        "name": "cat"
    },
    "name": "limon",
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
    public void review(){

        //Set the URL
        spec.pathParams("first","pet","second",55);

        //Send the requested get the response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        response.then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id",equalTo(55),
                        "category.name",equalTo("Cat"),
                        "name",equalTo("limon"),
                        "status",equalTo("available"));







    }

}
