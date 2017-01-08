package common;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith( SpringRunner.class )
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
abstract public class BaseIntegrationTest {

  @BeforeClass
  public static void setup() {
    int DEFAULT_PORT = 8080;

    String HOST = "http://localhost";

    String port = System.getProperty("server.port");
    if (port == null) {
      RestAssured.port = DEFAULT_PORT;
    } else {
      RestAssured.port = Integer.valueOf(port);
    }

    String basePath = System.getProperty("server.base");
    if (basePath == null) {
      basePath = "/";
    }
    RestAssured.basePath = basePath;

    String baseHost = System.getProperty("server.host");
    if (baseHost == null) {
      baseHost = HOST;
    }
    RestAssured.baseURI = baseHost;
  }
}