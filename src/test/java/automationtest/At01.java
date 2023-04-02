package automationtest;

import automationTestBase_urls.AutomationTestBase_urls;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class At01 extends AutomationTestBase_urls {
    /*
API 1: Get All Products List
API URL: https://automationexercise.com/api/productsList
Request Method: GET
Response Code: 200
Response JSON: All products list
     */


    @Test
    public void At01(){

        spec.pathParams("first","api","second","productsList");


        Map<String,Object> x=new HashMap<>();
        x.put("id",1);
        Response response=given(spec).get("{first}/{second}");
        response.prettyPrint();


        response.
                then().contentType(ContentType.JSON).statusCode(200);




    }

}
