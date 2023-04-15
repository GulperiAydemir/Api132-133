package HomeWorks.homeworks12;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static HomeWorks.homeworks12.HomeworkAuthenticationGmiBank.gmiBankToken;


public class GmiBankBaseUrl {
    protected RequestSpecification spec;
    private String gmiBankToken;

    @Before//This method will run before each @Test methods
    public void setUp(){
        spec=new RequestSpecBuilder().addHeader("Cookie","token="+gmiBankToken()).
                setBaseUri("https://www.gmibank.com").setContentType(ContentType.JSON).build();
    }
}