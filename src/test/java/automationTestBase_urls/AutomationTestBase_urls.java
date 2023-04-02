package automationTestBase_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class AutomationTestBase_urls {
    protected RequestSpecification spec;

    @Before//This METHOD WILL RUN BEFORE EACH @Test methods

    public void setUp() {

        spec = new RequestSpecBuilder().setBaseUri("https://automationexercise.com").build();


    }
}
