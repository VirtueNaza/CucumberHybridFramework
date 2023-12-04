package Hooks;

import Factory.DriverFactory;

import Utilities.ProjectProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class MyHooks {
    WebDriver driver;

    @Before
    public void setUp(){

        Properties prop = ProjectProperties.MyProperties();
        DriverFactory.initializeBrowser(prop.getProperty("browserType"));// initialize browser
         driver = DriverFactory.getDriver();// get driver reference

        driver.get(prop.getProperty("url"));

    }

    @After
    public void tearDown(Scenario scenario) {

        String testName = scenario.getName();


       if(scenario.isFailed()){
            byte[] base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(base64Screenshot, "image/png" ,testName+"test failed");

        }

        driver.quit();


    }
 /*if (scenario.isFailed()) {
        byte[] failedScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return failedScreenshot;
    }*/
        //return new byte[0];

}
