package practice;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetPractice01 extends HerOkuAppBaseUrl {
    /*
   Given
           https://restful-booker.herokuapp.com/booking/555
   When
           I send GET Request to the URL
   Then
           Status code is 200
                   {
                       "firstname": "Jane",
                       "lastname": "Doe",
                       "totalprice": 111,
                       "depositpaid": true,
                       "bookingdates": {
                           "checkin": "2018-01-01",
                           "checkout": "2019-01-01"
                       },
                       "additionalneeds":  "Extra pillows please"
                   }
*/

    @Test
    public void getPractice01() throws IOException {

        //Set the Url

        spec.pathParams("first","booking","second",55);

       //Set the Excepted Data

        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData=new BookingPojo("Josh","Allen",111,true,bookingDatesPojo,"midnight snack");
        System.out.println("expectedData = " + expectedData);

        //Send the request get the response

        Response response=given(spec).get("/{first}/{second}");
        response.prettyPrint();

        //Do assert

        assertEquals(200,response.statusCode());

        BookingPojo actualData=new ObjectMapper().readValue(response.asString(),BookingPojo.class);
        System.out.println("actualData = " + actualData);

        JsonPath jsonpath=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(),200);
        assertEquals(actualData.getFirstname(),expectedData.getFirstname());
        assertEquals(actualData.getLastname(),expectedData.getLastname());
        assertEquals(actualData.getTotalprice(),expectedData.getTotalprice());
        assertEquals(actualData.getDepositpaid(),expectedData.getDepositpaid());
        assertEquals(actualData.getBookingdates().getCheckin(),expectedData.getBookingdates().getCheckin());
        assertEquals(actualData.getBookingdates().getCheckout(),expectedData.getBookingdates().getCheckout());

        softAssert.assertAll();


    }
}
