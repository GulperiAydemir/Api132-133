package practiseHomework;

import base_urls.RegresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Hw06 extends RegresBaseUrl {
    /*
      Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then
            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
     */
    //Set the Url

    @Test
    public void review01(){
        spec.pathParams("first","api","second","unknown");
     //Send the request get the response

        Response response =given().spec(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do Assertion

        // 1)Status code is 200

        response.then().assertThat().statusCode(200);

//        2)Print all pantone_values
        JsonPath json=response.jsonPath();
        List<String> pantone_values=json.getList("data.pantone_values");
        System.out.println("pantone_values = " + pantone_values);

        //    Print all ids greater than 3 on the console
        //    Assert that there are 3 ids greater than 3

        List<Integer> ids=json.getList("data.findAll{it.id>3}.id");
        System.out.println("ids_grater = " + ids);


       assertEquals(3,ids.size());


//        4)Print all names whose ids are less than 3 on the console
//        Assert that the number of names whose ids are less than 3 is 2

        List<String> names=json.getList("data.findAll{it.id<3}.names");
        System.out.println(names);

        assertEquals(2,names.size());





    }
}
