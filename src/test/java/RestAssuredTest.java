import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class RestAssuredTest {

    String baseUrl = "https://reqres.in/";

    @Test
    public void verifyGetMethod(){
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .pathParam("pageNumber", "2")
                .log().all()
                .when()
                .get(baseUrl + "api/users?page={pageNumber}");
        response.then().log().all()
                .assertThat()
                .statusCode(200)
                .body("page", Matchers.equalTo(2));
    }
}
