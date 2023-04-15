package HomeWorks.homeworks12;

import base_urls.GmiBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;


import static HomeWorks.homeworks12.HomeworkAuthenticationGmiBank.gmiBankToken;
import static io.restassured.RestAssured.given;

public class Homework12 extends GmiBankBaseUrl {
    /*
    //Type an automation test that creates a "country" which includes at least 3 "states"
    using the document //https://app.swaggerhub.com/apis/yasinaniltechpro/GmiBank/0.0.1.
     */
    @Test
    public void homework12(){
        //Set the Url
        spec.pathParams("first","api","second","tp-countries");
        Response response = given(spec).
                headers("Authorization", "Bearer " + gmiBankToken()).
                get("{first}/{second}");
        response.prettyPrint();




    }
}