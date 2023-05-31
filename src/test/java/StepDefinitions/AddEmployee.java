package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utills.CommonMethods;
import utills.ConfigReader;

public class AddEmployee extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
    //WebElement pimTab =driver.findElement(By.id("menu_pim_viewPimModule"));
    doClick(addEmployeePage.pimTab);
    }
    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
       // WebElement addbtn=driver.findElement(By.id("menu_pim_addEmployee"));
        doClick(addEmployeePage.eddEmpBtn);
    }
    @When("user enters first name and middle name and last name")
    public void user_enters_first_name_and_middle_name_and_last_name() {
      //  System.out.println(10/0);
   // WebElement firstNameTextBox=driver.findElement(By.id("firstName"));
    sendText(addEmployeePage.firstNameTextBox,ConfigReader.getPropertyValue("firstname"));

   // WebElement middleNameTextBox=driver.findElement(By.id("middleName"));
    sendText(addEmployeePage.middleNameTextBox,ConfigReader.getPropertyValue("middlename"));

    //WebElement lastNameTextBox= driver.findElement(By.id("lastName"));
    sendText(addEmployeePage.lastNameTextBox,ConfigReader.getPropertyValue("lastname"));
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
      //  WebElement saveBtn=driver.findElement(By.id("btnSave"));
doClick(addEmployeePage.saveBtn);
    }


    @Given("user enters {string} and {string} and  {string}")
    public void user_enters_and_and(String string, String string2, String string3) {
       sendText(addEmployeePage.firstNameTextBox,"firstname");
    }
    @Given("user captures the employee id")
    public void user_captures_the_employee_id() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("query the information in backend")
    public void query_the_information_in_backend() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("verify the results from frontend and backend")
    public void verify_the_results_from_frontend_and_backend() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
