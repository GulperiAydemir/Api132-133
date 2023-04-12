package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get06Review extends HerOkuAppBaseUrl {
    @Test

    public void get06(){

         /*
        Given
            https://restful-booker.herokuapp.com/booking/32
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
                {
                    "firstname": "Jane",
                    "lastname": "Doe",
                    "totalprice": 111,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2018-01-01",
                        "checkout": "2019-01-01"
                    },
                    "additionalneeds": "Extra pillows please"
                }
     */
        //Set the Url
        spec.pathParams("first","booking","second",32);

        //Set the expected data

        //Send the request get the response

        Response response=given(spec).when().get("/{first}/{second}");
        response.prettyPrint();

//        //Do assert
//        Map<String,String> bookingdates=new HashMap<>();
//        bookingdates.put("2018-01-01","chekin");
//        bookingdates.put("2019-01-01","chekout");
//
//     response.then().
//             statusCode(200).
//             contentType(ContentType.JSON).
//             body("firstname",equalTo("Josh"),
//                     "lastname",equalTo("Allen"),
//                     "totalprice",equalTo(111),
//                     "depositpaid",equalTo(true),
//                     "bookingdates.checkin",equalTo("2018-01-01"),
//                     "bookingdates.checkout",equalTo("2019-01-01"),
//                     "additionalneeds",equalTo("super bowls"));

        //2.Way

        JsonPath json =response.jsonPath();
        assertEquals("Jane",json.getString( "firstname"));
        assertEquals("Doe",json.getString( "lastname"));
        assertEquals(111,json.getInt("totalprice"));
        assertEquals(true,json.getBoolean( "depositpaid"));
        assertEquals("2018-01-01", json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01", json.getString("bookingdates.checkout"));
        assertEquals("Extra pillows please",json.getString("additionalneeds"));

        //3.Way

        //1.Soft assert Object create

        SoftAssert softAssert=new SoftAssert();

        //2.Assertion

        softAssert.assertEquals(json.getString("firstname"),"Jane","Not succesfull");
        softAssert.assertEquals(json.getString("lastname"),"Doe","Not succesfull");
        softAssert.assertEquals(json.getInt("totalprice"),111,"Not succesfull");
        softAssert.assertTrue(json.getBoolean("depositpaid"),"Not succesfull");
        softAssert.assertEquals(json.getString("bookingdates.checkin"),"2018-01-01","Not succesfull");
        softAssert.assertEquals(json.getString("bookingdates.checkout"),"2019-01-01","Not succesfull");
        softAssert.assertEquals(json.getString("additionalneeds"),"Extra pillows please","Not succesfull");


        //3.softAssert.assertAll() diyerek dogrulama kontrol edilecek

        softAssert.assertAll();



    }

}
