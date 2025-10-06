package UITesting;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenURL;

import static util.UITestUtil.*;

public class LoginTest extends OpenURL {

    Login login;

    @BeforeClass
    public void initLogin()
    {
        login = new Login(driver);
    }

  /*  @Test
    public void txtUsernameVisibility()
    {
       boolean expected = true;
       boolean actual = false;
       try {
           actual = login.txtUsername.isDisplayed();
       } catch (Exception e) {
         //  actual = false;
       }
        Assert.assertEquals(actual,expected);
    }*/


    @Test
    public void txtUsernameVisibility()
    {
        boolean expected = true;
        boolean actual = checkVisibility(login.txtUsername);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void txtPasswordVisibility()
    {
        boolean expected = true;
        boolean actual = checkVisibility(login.txtPassword);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void txtUsernameEnabibility()
    {
        boolean expected = true;
        boolean actual = checkEnability(login.txtUsername);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void txtPasswordEnabibility()
    {
        boolean expected = true;
        boolean actual = checkEnability(login.txtPassword);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void lblEmailSpellCheck()
    {
        String expected = "Email";
        String actual = checkSpelling(login.lblEmail);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void lblPasswordSpellCheck()
    {
        String expected = "Password";
        String actual = checkSpelling(login.lblPassword);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void lblEmailWatermarkCheck()
    {
        String expected = "Email";
        String actual = checkPlaceholder(login.txtUsername);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void lblPasswordWatermarkCheck()
    {
        String expected = "Password";
        String actual = checkPlaceholder(login.txtPassword);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void lblEmailFontSizeCheck()
    {
        String expected = "14px";
        String actual = checkCssValue(login.lblEmail,"font-size");
        System.out.println("Expected="+expected);
        System.out.println("Actual="+actual);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void lblEmailFontFamilyCheck()
    {
        String expected = "-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";
        String actual = checkCssValue(login.lblEmail,"font-family");
        System.out.println("Expected="+expected);
        System.out.println("Actual="+actual);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void buttonLoginColorCheck()
    {
        String expected = "#2C8EDD";
        String actual = checkColor(login.btnLogin,"background-color").toUpperCase();
        System.out.println("Expected="+expected);
        System.out.println("Actual="+actual);
        Assert.assertEquals(actual,expected);
    }









}
