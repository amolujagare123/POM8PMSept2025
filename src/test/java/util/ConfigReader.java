package util;

import java.util.ResourceBundle;

public class ConfigReader {

    static ResourceBundle rb = ResourceBundle.getBundle("config");

   public static String getUrl()
   {
       return rb.getString("url");
   }

    public static String getUsername()
    {
        return rb.getString("username");
    }

    public static String getPassword()
    {
        return rb.getString("password");
    }
}
