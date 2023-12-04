package Utilities;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MyUtils {

    public static final int Explicit_Wait_Time = 30;
    public static final int Implicit_Wait_Time=15;

    public static final int Maximum_Time_Out_Time=30;
    public static String generateEmail(){
        Date date = new Date();
        return "nazababy"+ date.toString().replace(" ", "_").replace(":","_")+"@gmail.com";
    }



}
