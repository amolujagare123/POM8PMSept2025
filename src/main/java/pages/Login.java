package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
  /*  WebDriver driver;
    WebElement element = driver.findElement(By.id("email"));*/

    @FindBy (id = "email")
    WebElement txtUsername;

    @FindBy (id = "password")
    WebElement txtPassword;

    @FindBy (xpath = "//button")
    WebElement btnLogin;

    @FindBy(xpath = "//a[contains(text(), 'forgot')]")
    WebElement forgotPassword;

    public void clickForgotPassword()
    {
        forgotPassword.click();
    }

    public Login(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setTxtUsername(String username)
    {
        txtUsername.sendKeys(username);
    }

    public void setTxtPassword(String password)
    {
        txtPassword.sendKeys(password);
    }

    public void clickLogin()
    {
        btnLogin.click();
    }


}
