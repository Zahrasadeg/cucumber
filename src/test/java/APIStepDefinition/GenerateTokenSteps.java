package APIStepDefinition;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
public class GenerateTokenSteps {
    public static String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    public static String token;


    @Given("a JWT generated")
    public void a_jwt_generated() {
        RequestSpecification generateTokenRequest= given().header("Content-Typ","application/json").
                body("{\n" +
                        "\"email\": \"zahra2@hotmail.com\",\n" +
                        "    \"password\": \"zahra123\"\n" +
                        "} ");
        //hitting the end point
        Response response=generateTokenRequest.when().post("/generateToken.php");
//store the token
        token="Bearer "+response.jsonPath().getString("token");
        System.out.println(token);
    }



}
