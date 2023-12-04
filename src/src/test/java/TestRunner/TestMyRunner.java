package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
                  glue ={"Hooks","StepDefinitions"},
                   plugin={"pretty", "html:target//Cucumberreport//cucumber.html"},
                   publish =true,
                   tags ="@addToCart"

                   )
public class TestMyRunner{
}