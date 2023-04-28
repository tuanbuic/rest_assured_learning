package rest;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Log {
    @Test
    public void test() {
        String a = given().
                baseUri("https://reqres.in/")
                .when().
                get("/api/users?page=2").
                then().
                log().all()
                .assertThat().statusCode(200).toString();

    }
}
