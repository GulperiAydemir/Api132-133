package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class Get12 extends GoRestBaseUrl {
    /*
    Given
        https://gorest.co.in/public/v1/users
    When
        User send GET Request
    Then
        The value of "pagination limit" is 10
    And
        The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
    And
        The number of users should  be 10
    And
        We have at least one "active" status
    And
        "Chidambar Dhawan", "dhawan_chidambar@harber.com" and "Rev. Jay Shukla" are among the users
    And
        The female users are less than or equals to male users
*/

@Test
    public void get12(){

    //Set the Url
    spec.pathParam("first","users");


    //Set the Expected Data


    //Send the request get the Response
   Response response=given(spec).get("/{first}");
   response.prettyPrint();

   //Do Assertion

    response.then().body("meta.pagination.limit",equalTo(10),
            "meta.pagination.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1"),
            "data",hasSize(10),
            "data.status",hasItem("active"),
            "data.name",hasItems("Chidambar Dhawan","Gopi Kakkar","Anunay Gowda LLD"));

    //The Female users are less than or equals to male users

    //1.Way:We will get all the genders inside a list then we will count the number of females

    JsonPath json=response.jsonPath();
    List<String> genderList=json.getList("data.gender");
    System.out.println("genderList = " + genderList);//genderList = [female, male, male, male, female, female, female, male, male, male]

    int numOfFemales=0;
    for(String w:genderList){
        if(w.equals(("female"))){
            numOfFemales++;


        }

    }
    System.out.println("numOfFemales = " + numOfFemales);

    assertTrue(numOfFemales<=genderList.size()-numOfFemales);

    //2nd Way:We will get all females inside a list by using groovy then compare it with males
    List<String> femaleList=json.getList("data.findAll{it.gender=='female'}.gender");
    System.out.println("femaleList = " + femaleList);

    List<String> maleList=json.getList("data.findAll{it.gender=='male'}.gender");
    System.out.println("maleList = " + maleList);

    assertTrue(femaleList.size() <=maleList.size());


}
}
