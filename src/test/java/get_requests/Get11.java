package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;

public class Get11 extends HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/49
    When
        I send GET Request to the url
    Then
        Response body should be like that;
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

    @Test
    public void get11(){

        //Set the Url

        spec.pathParams("first","booking","second",123);

        //Set the expected Data

        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData=new BookingPojo("Jane","Doe",111,true,bookingDatesPojo,"Extra pillows please");

        System.out.println("expectedData = " + expectedData);

        //Send the request Get the Response

        Response response=given(spec).get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion

        BookingPojo actualData=response.as(BookingPojo.class);

        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        Assert.assertEquals(expectedData.getLastname(),actualData.getLastname());
        Assert.assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        Assert.assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());


        Assert.assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        Assert.assertEquals(expectedData.getBookingdates().getCheckout(),actualData.getBookingdates().getCheckout());

        //Recoomended way:

        Assert.assertEquals(bookingDatesPojo.getCheckin(),actualData.getBookingdates().getCheckin());
        Assert.assertEquals(bookingDatesPojo.getCheckout(),actualData.getBookingdates().getCheckout());

        Assert.assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());



    }
}
