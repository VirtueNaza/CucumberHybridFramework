package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

<<<<<<< HEAD


=======
>>>>>>> 250c9764f758c0bb032ac01f58741cd56330a463
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
                  glue ={"Hooks","StepDefinitions"},
                   plugin={"pretty", "html:target//Cucumberreport//cucumber.html"},
                   publish =true,
                   tags ="@addToCart"

                   )
<<<<<<< HEAD
public class TestMyRunner{
}
=======

public class TestMyRunner {


}
>>>>>>> 250c9764f758c0bb032ac01f58741cd56330a463
