package regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.ForgotPassword;
import pages.Login;

public class ForgotPasswordTest {

    @Test
    public void loginTest()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/ip");

        Login login = new Login(driver);
        login.clickForgotPassword();

        ForgotPassword forgotPassword = new ForgotPassword(driver);
        forgotPassword.setEmail("amol@gmail.com");
        forgotPassword.clickReset();

    }
}
