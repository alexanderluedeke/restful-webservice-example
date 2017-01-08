package echo;

import com.jayway.restassured.http.ContentType;
import common.BaseIntegrationTest;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class EchoTest extends BaseIntegrationTest {
  @Test
  public void basicPingTest() {
    given()
        .when()
        .accept(ContentType.JSON)
        .get("/echo")

        .then()
        .statusCode(200);
  }

  @Test
  public void shouldContainId() {
    given()
        .when()
        .get("/echo")

        .then()
        .body(containsString("id"));
  }

  @Test
  public void shouldContainDefaultContent() {
    given()
        .when()
        .get("/echo")

        .then()
        .body("content", equalTo("Hello, User!"));
  }

  @Test
  public void shouldContainParameterValue(){
    given()
        .when()
        .get("/echo?name=Alexander")

        .then()
        .body("content", equalTo("Hello, Alexander!"));
  }
}