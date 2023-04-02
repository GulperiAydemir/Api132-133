package practice;

import base_urls.RegresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.IDynamicGraph;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Q02 extends RegresBaseUrl {
    /*
    Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

    @Test
    public void Q02(){
        spec.pathParams("first", "api", "second", "users");
        Map<String, String> expectedData= new HashMap<>();

        expectedData.put("name", "morpheus");
        expectedData.put("job", "leader");
        System.out.println("expectedData = " + expectedData);

        Response response= given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}/{second}");
        response.prettyPrint();

        Map<String, String> actualData= response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        Assert.assertEquals(201, response.getStatusCode());
        Assert.assertEquals(expectedData.get("name"), actualData.get("name"));
        Assert.assertEquals(expectedData.get("job"), actualData.get("job"));

        short min=Short.MIN_VALUE;



    }
}
