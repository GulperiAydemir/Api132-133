package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.io.SessionOutputBuffer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08Review extends JsonPlaceHolderBaseUrl {
    /*
        Given
              https://jsonplaceholder.typicode.com/todos
      When
          I send GET Request to the URL
      Then
          1)Status code is 200
          2)Print all ids greater than 190 on the console
            Assert that there are 10 ids greater than 190
          3)Print all userIds whose ids are less than 5 on the console
            Assert that the number of userIds whose ids are less than 5 is 4
          4)Print all titles whose ids are less than 5
            Assert that "delectus aut autem" is one of the titles whose id is less than 5
     */

    @Test

    public void get08 (){

        //Set the Url
        spec.pathParam("first","todos");

        //Set the Expected Data

        //Send the request get the Response

        Response response=given(spec).get("/{first}");
        response.prettyPrint();

        //Do Assertion

        assertEquals(200,response.statusCode());

        //Print all ids greater than 190 on the console

        JsonPath json=response.jsonPath();

        List<Integer> Idlist=new ArrayList<>();
        System.out.println("Idlist = " + Idlist);

        //1.Way

        int ideasGreater=0;

        for(int w:Idlist){
            if(w>190){
                ideasGreater++;

                //2.Way Recommended Way

         List<Integer> intListGroovy=json.getList("findAll{it.id>190}.id");

                System.out.println("intListGroovy = " + intListGroovy);

                assertEquals(10,intListGroovy.size());

             List<Integer> userId= json.getList("findAll{it.id<5}.userId");
                System.out.println("userId = " + userId);

                assertEquals(4,userId.size());

              //  4)Print all titles whose ids are less than 5
              //  Assert that "delectus aut autem" is one of the titles whose id is less than 5

              List<String> titleList=  json.getList("findAll{it.id<5}.title");

              assertEquals("title uyusmadi",titleList.contains("delectus aut autem"));
              String title="";
              for(String z :titleList){
                  if( z.equals("delectus aut autem")){
                      System.out.println(title + w);
                  }

              }

            }


        }




    }
}
