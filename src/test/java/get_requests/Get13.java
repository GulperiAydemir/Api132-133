package get_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;


import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

public class Get13 extends DummyRestApiBaseUrl {
    /*
    Given
        https://dummy.restapiexample.com/api/v1/employees
    When
        User sends Get Request to the Url
    Then
        Status code is 200
    And
        There are 24 employees
    And
        "Tiger Nixon" and "Garrett Winters" are among the employees
    And
        The greatest age is 66
    And
        The name of the lowest age is "[Tatyana Fitzpatrick]"
    And
        Total salary of all employees is 6,644,770
     */

    @Test
    public void get13() {
        //Set the url
        spec.pathParam("first", "employees");

        //Set the expected data

        //Send the request and get response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //Do assertion
        response.
                then().
                statusCode(200).
                body("data", hasSize(24),//There are 24 employees
                        "data.employee_name", hasItems("Tiger Nixon", "Garrett Winters"));//"Tiger Nixon" and "Garrett Winters" are among the employees

        //The greatest age is 66
        JsonPath jsonPath = response.jsonPath();
        List<Integer> ages = jsonPath.getList("data.employee_age");
        System.out.println("ages = " + ages);//[61, 63, 66, 22, 33, 61, 59, 55, 39, 23, 30, 22, 36, 43, 19, 66, 64, 59, 41, 35, 30, 40, 21, 23]
        Collections.sort(ages);
        System.out.println("sorted ages = " + ages);//[19, 21, 22, 22, 23, 23, 30, 30, 33, 35, 36, 39, 40, 41, 43, 55, 59, 59, 61, 61, 63, 64, 66, 66]
        int greatestAge = ages.get(ages.size() - 1);//ages.size()-1==> last element's index
        System.out.println("greatestAge = " + greatestAge);//66
        assertEquals(66, greatestAge);

        //The name of the lowest age is "[Tatyana Fitzpatrick]"
        //ages.get(0) ==> will give always lowest age and this will make our code dynamic
        String nameOfTheLowestAge = jsonPath.getString("data.findAll{it.employee_age==" + ages.get(0) + "}.employee_name");
        System.out.println("nameOfTheLowestAge = " + nameOfTheLowestAge);
        assertEquals("[Tatyana Fitzpatrick]", nameOfTheLowestAge);

        //Total salary of all employees is 6,644,770
        List<Integer> salaries = jsonPath.getList("data.employee_salary");
        System.out.println("salaries = " + salaries);

        //1st Way: ForEach Loop
        int sumOfSalaries = 0;
        for (int w : salaries) {

            sumOfSalaries += w;

        }
        System.out.println("sumOfSalaries = " + sumOfSalaries);
        assertEquals(6644770, sumOfSalaries);

        //2nd Way: Functional Programming ==> Recommended
        int sumOfSalariesLambda = salaries.stream().reduce(0, Math::addExact);
        System.out.println("sumOfSalariesLambda = " + sumOfSalariesLambda);

        assertEquals(6644770, sumOfSalariesLambda);

    }
}