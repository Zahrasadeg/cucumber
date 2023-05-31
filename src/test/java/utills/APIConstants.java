package utills;

import io.restassured.RestAssured;

public class APIConstants {
    public static final String BaseURI= RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
    public static final String GENERATE_TOKEN_URI=BaseURI+"/generateToken.php";
    public static final String CREATE_EMPLOYEE_URI=BaseURI+"/createEmployee.php";
    public static final String GET_ONE_EMPLOYEE_URL=BaseURI+"/getOneEmployee.php";
    public static final String GET_ALL_EMPLOYEE_URI = BaseURI+"/getAllEmployees.php";
    public static final String UPDATE_EMPLOYEE_URL=BaseURI+"/updateEmployee.php";
    public static final String UPDATE_PARTIAL_EMPLOYEE_URL=BaseURI+"/updatePartialEmplyeesDetails.php";

    public static final String GET_EMPLOYEE_STATUS_URL=BaseURI+"/employeementStatus.php";

    public static final String HEADER_KEY_CONTENT_TYPE="Content-Type";
    public static final String HEADER_VALUE_CONTENT_TYPE="application/json";
    public static final String HEADER_KEY_AUTHORIZATION="Authorization";

}
