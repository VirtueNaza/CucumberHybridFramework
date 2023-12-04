package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjectProperties {

    public static  Properties MyProperties()  {

        //File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\config.properties");

        FileInputStream fis = null;
        try {fis = new FileInputStream( new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\config.properties"));
        }catch(Exception e){
            e.printStackTrace();
        }

        Properties prop = new Properties();

        try {
            prop.load(fis);
        }catch(Exception e){
            e.printStackTrace();
        }

        return prop;
    }

}
