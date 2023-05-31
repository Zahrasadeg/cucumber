package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utills.CommonMethods;
import utills.ConfigReader;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class Login extends CommonMethods {

    @Given("open the browser and launch HRMS application")
    public void open_the_browser_and_launch_hrms_application() {
        openBrowserLaunchApp();
    }

    @When("user enters valid email and valid password")
    public void user_enters_valid_email_and_valid_password() {
       // LoginPage login=new LoginPage();

       // WebElement name = driver.findElement(By.id("txtUsername"));
        sendText(login.usernameTextBox, ConfigReader.getPropertyValue("username"));
        //WebElement pass = driver.findElement(By.id("txtPassword"));
        sendText(login.passwordTextBox, ConfigReader.getPropertyValue("password"));
    }

    @When("click on login button")
    public void click_on_login_button() {
       // LoginPage login=new LoginPage();
        WebElement loginBTN = driver.findElement(By.id("btnLogin"));
        doClick(loginBTN);
    }

    @Then("user is logged in successfully.")
    public void user_is_logged_in_successfully() {
        //LoginPage login=new LoginPage();
        boolean userloggedIn = driver.findElement(By.xpath("//a[contains(text(), 'Welcome')]")).isDisplayed();
        if (userloggedIn) {
            System.out.println("User is logged in Successfully");
        }


    }

    @Then("close the browser")
    public void close_the_browser()
    {//LoginPage login=new LoginPage();
        closeBrowser();
    }

    @When("user enters valid {string} and valid {string}")
    public void user_enters_valid_and_valid(String username, String password) {
       // LoginPage login=new LoginPage();
        WebElement usernameTextBox = driver.findElement(By.id("txtUsername"));
        sendText(usernameTextBox, username);

        WebElement passwordTextBox = driver.findElement(By.id("txtPassword"));
        sendText(passwordTextBox, password);
    }

    @When("user enters username and password and verifies login")
    public void user_enters_username_and_password_and_verifies_login(DataTable dataTable) {


       // LoginPage login=new LoginPage();
        List<Map<String, String>> userCredentials = dataTable.asMaps();
        for (Map<String, String> userCreds : userCredentials) {
            String username = userCreds.get("username");
            String password = userCreds.get("password");

            sendText(login.usernameTextBox, username);

            sendText(login.passwordTextBox, password);

            doClick(login.loginBtn);

            doClick(login.welcomeIcon);

            doClick(login.logoutLink);


        }


    }
}






