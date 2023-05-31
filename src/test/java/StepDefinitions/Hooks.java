package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utills.CommonMethods;

public class Hooks extends CommonMethods {
    @Before
    public void preConditions(){
        openBrowserLaunchApp();
    }


    //scenario class holds the complete information of your test execution in cucumber framework
    @After
    public void postConditions(Scenario scenario){
        byte[]pic;
        if(scenario.isFailed()){
            pic=TakeScreenshot("failed/"+scenario.getName());
        }else{
            pic=TakeScreenshot("passed/"+scenario.getName());
        }
        //attach the screen sot in my report
        scenario.attach(pic, "image/png", scenario.getName());


        closeBrowser();
    }

}
