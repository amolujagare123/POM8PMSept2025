package regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.ForgotPassword;
import pages.Login;
import util.OpenURL;

public class ForgotPasswordTest extends OpenURL {

    @Test
    public void loginTest()
    {

        Login login = new Login(driver);
        login.clickForgotPassword();

        ForgotPassword forgotPassword = new ForgotPassword(driver);
        forgotPassword.setEmail("amol@gmail.com");
        forgotPassword.clickReset();

    }
}
