import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class APITests {
    
    @Test
    public void Test1(){
        Response response = RestAssured.get("https://www.reqres.in/api/users?page=2");

//        System.out.println("Response= "+ response.asString());
        System.out.println("Status code= " + response.getStatusCode());
//        System.out.println("Body= " + response.getBody().asString());
        System.out.println("Time Taken= " + response.getTimeIn(TimeUnit.SECONDS));
        System.out.println("Header= " + response.getHeader("content-type"));
//        System.out.println("Cookies=" + response.getCookies());
        System.out.println("Content Type= " + response.getContentType()+" and Session ID= "+response.getSessionId());

        if(response.getTimeIn(TimeUnit.SECONDS)<=10){
            System.out.println("response received within 10 seconds");
        }
        else {
            System.out.println("response received in more than 10 seconds");
        }

        int httpsResponseCode = response.getStatusCode();

        if (httpsResponseCode==200){
            System.out.println("Response Code is 200");
        } else if (httpsResponseCode==404){
            System.out.println("Response Code is 404");
        } else{
            System.out.println("Response Code is neither 200 nor 404");
        }

        try {
            assertEquals(httpsResponseCode, 404);
            System.out.println("try block is executed");
        }catch (Exception e){
            System.out.println("Exception occurred while checking assertion");
            System.out.println("catch block is executed");
        }finally {
            System.out.println("Finally block is executed");
        }

    }
}
