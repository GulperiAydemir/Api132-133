package get_requests;

import base_urls.RegresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class HomeWork05 extends RegresBaseUrl {
    //Homework5:
    /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */
    @Test
    public  void homeWork05(){
        //Set the URL

        spec.pathParams("first","unkown","second",3);

        //Send the request get the response

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion

        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON);

        JsonPath jsonPath = response.jsonPath();

        //2nd Step: Do assertion by using SoftAssert object
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(jsonPath.getInt("data.id"), 3, "id did NOT match");
        softAssert.assertEquals(jsonPath.getString("data.name"), "true red", "name did NOT match");
        softAssert.assertEquals(jsonPath.getInt("data.year"), 2002, "year did NOT match");
        softAssert.assertEquals(jsonPath.getString("data.color"), "#BF1932", "color did NOT match");
        softAssert.assertEquals(jsonPath.getString("data.pantone_value"), "19-1664", "pantone did NOT match");

//3rd Step: Use assertAll() method.
        softAssert.assertAll();



    }
}
