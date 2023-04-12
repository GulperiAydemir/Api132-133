package HomeWorks;

import automationTestBase_urls.AutomationTestBase_urls;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Homework10 extends AutomationTestBase_urls {

    //Homework10:

/*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends Get request
        Note: use prettyPrint like: response.jsonPath().prettyPrint()
    Then
        Assert that number of "Women" usertype is 12

*/
@Test
        public void homework10(){
    //Set the Url

   // String url="https://automationexercise.com/api/productsList";
    spec.pathParams("first","api","second","productsList");

    //Set the response get the request

    Response response = given(spec).when().contentType(ContentType.JSON).get("{first}/{second}");
    response.jsonPath().prettyPrint();


    //Do assertion


    JsonPath json = response.jsonPath();
    List<String> usertype = json.getList("products.category.usertype.usertype");
    System.out.println("usertype = " + usertype);

    int numOfWomanUser = json.getList("products.findAll{it.category.usertype.usertype=='Women'}").size();
    assertEquals(12,numOfWomanUser);
    List<String> women=new ArrayList<>();

    for(int i=0 ; i< usertype.size();i++){
        if(usertype.get(i).equals("Women")){
            women.add(usertype.get(i));
        }
    }
    System.out.println("women = " + women);
    assertEquals(12,women.size());

    int womenSize=0;
    for (int i =0 ; i<usertype.size();i++){
        if(usertype.get(i).equals("Women")){
            womenSize++;
        }
    }
    assertEquals(12,womenSize);


        }
    }






