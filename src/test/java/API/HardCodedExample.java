package API;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExample {

    String baseURI= RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";

    String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUxODkwNDAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTIzMjI0MCwidXNlcklkIjoiNTMzOCJ9.Ahu7XvowCxz1mRV6B15n7xnuk4GWkmSiDhRsc4YrSEc";
    public static String employee_id;



    @Test
    public void bgetEmployee(){
        RequestSpecification preparedRequest=given().
                header("Content-Type","application/json").
                header("Authorization",token).
                queryParam("employee_id",employee_id);

        //hitting the endpoint
        Response response=preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        //verify the response
        response.then().assertThat().statusCode(200);
        String tempEmpId=response.jsonPath().getString("employee.employee_id");
        //we have 2 id second is local
        Assert.assertEquals(employee_id,tempEmpId);
    }
    @Test
    public void acreateEmployee(){
        RequestSpecification preparedrequest=given().
                header("Content-Type","application/json").

                header("Authorization",token).body("{\n" +
                        "  \"emp_firstname\": \"zahra\",\n" +
                        "  \"emp_lastname\": \"jon\",\n" +
                        "  \"emp_middle_name\": \"z\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2001-05-13\",\n" +
                        "  \"emp_status\": \"confirmed\",\n" +
                        "  \"emp_job_title\": \"Engineer\"\n" +
                        "}");
        //hiiting the endpoint/send the request
        Response response=preparedrequest.when().post("/createEmployee.php");
         response.then().assertThat().statusCode(201);
        response.prettyPrint();
        employee_id=response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);


        response.then().assertThat().body("Employee.emp_firstname", equalTo("zahra"));
        response.then().assertThat().body("Employee.emp_lastname", equalTo("jon"));

        response.then().assertThat().header("Content-Type","application/json");

        System.out.println("My test case is passed");

}
@Test
public void cupdateEmployee(){
    RequestSpecification preparedRequest=given().
            header("Content-Type","application/json").

            header("Authorization",token).body("{\n" +
                    "  \"employee_id\": \""+employee_id+"\",\n" +
                    "  \"emp_firstname\": \"zara\",\n" +
                    "  \"emp_lastname\": \"mah\",\n" +
                    "  \"emp_middle_name\": \"love\",\n" +
                    "  \"emp_gender\": \"F\",\n" +
                    "  \"emp_birthday\": \"2000-05-21\",\n" +
                    "  \"emp_status\": \"lovely\",\n" +
                    "  \"emp_job_title\": \"engenieer\"\n" +
                    "}");
    Response response=preparedRequest.when().put("/updateEmployee.php");
    response.then().assertThat().statusCode(200);
    response.then().assertThat().body("Message",equalTo("Employee record Updated"));



}
@Test
    public void dgetUpdateEmployee(){
    RequestSpecification preparedRequest=given().
            header("Content-Type","application/json").
            header("Authorization",token).
            queryParam("employee_id",employee_id);
    Response response=preparedRequest.when().get("/getOneEmployee.php");
    response.prettyPrint();
    response.then().assertThat().statusCode(200);
    //verify
    //hamcrest

}

    }
