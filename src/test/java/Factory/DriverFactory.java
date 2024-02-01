package Factory;

import Utilities.MyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    static WebDriver driver;

    public static void initializeBrowser(String browserName) {
        if(browserName.equals("chrome")){
            driver = new ChromeDriver();
        }else if(browserName.equals("edge")){
            driver = new EdgeDriver();
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        }

        switch (browserName){
            case "chrome": driver=new ChromeDriver();
            case "fireFox": driver = new FirefoxDriver();
            case "edge" : driver = new EdgeDriver();

        }

    }

    public static WebDriver getDriver(){
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(MyUtils.Maximum_Time_Out_Time));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(MyUtils.Implicit_Wait_Time));
        return driver;
    }
}
