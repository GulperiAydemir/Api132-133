package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestAndResponse {

    /*
    1) Postman is used for manual api testing
    2) We use RestAssured library for API Automation Testing
    3) To type automation csript follow these steps:
    a)Understand the requirement
    b)Type test cases
      To type the test cases we use 'Gherkin Language'
      The keywords are : x) Given :It is used for pre-condition
                         y) When :It is used for actions (Requests...)
                         z) Then :It is used for output (Assertion...)
                         t) And : Is is used for multiple usage of Given,When and Then

   c)Starts to type Automation Script
       i)Set the URL
       ii)Set teh expected data
       iii)Send the request and get the responce
       iv)Do assertion

     */
    /*
        Given
            https://restful-booker.herokuapp.com/booking/10
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    public static void main(String[] args) {

        String url ="https://restful-booker.herokuapp.com/booking/10";
        //User sends a GET Request to the url
        Response response=given().when().get(url);
        response.prettyPrint();

        //HTTP Status Code Should be 200
        System.out.println(response.statusCode());

        // Content Type should be JSON
        System.out.println(response.contentType());

        //Status Line should be HTTP/1.1 200 OK

        System.out.println(response.statusLine());

        //How to see "Header" on console:
        System.out.println(response.header("Connection"));

        //How to see "Header" on console:
        System.out.println(response.headers());

        //How to see "Time" on console
        System.out.println(response.time());






    }

}
