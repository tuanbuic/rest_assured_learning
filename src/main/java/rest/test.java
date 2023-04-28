package rest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class test {
    @Test
    public void test() {
        String a = given().
                baseUri("https://reqres.in/").
                when().
                get("/api/users?page=2").
                then().extract().response().asString();
        System.out.println(a);
        String b = JsonPath.from(a).getString("data[0].first_name");
        System.out.println(b);
    }

    public void test1_hamcrestAssert() {
        given().baseUri("https://reqres.in/").
                when().
                get("/api/users?page=2").
                then().assertThat().statusCode(200).
                body("data", is(not(emptyArray())));
    }
}
