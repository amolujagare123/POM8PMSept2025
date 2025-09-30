package regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Login;
import pages.Menu;
import util.DoLogin;

import java.io.IOException;

import static util.ForDataProvider.getMyData;

public class AddClientDataPrividerTest extends DoLogin  {

    @Test(dataProvider = "getData")
    public void addClientTest(String clientName, String clientSurname, String language,
                              String street1, String street2, String city, String state,
                              String zip, String country,
                              String phone, String fax, String mobile,
                              String email, String website,
                              String gender, String birthdate,
                              String vatId, String taxCode,String expected,String xpathActual) {

        // Navigate to Add Client Page
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        // Create AddClientPage object
        AddClient addClient = new AddClient(driver);

        // Fill in Personal Information
        addClient.enterClientName(clientName);
        addClient.enterClientSurname(clientSurname);
        addClient.selectLanguage(language);

        // Fill in Address
        addClient.enterAddress(
                street1,
                street2,
                city,
                state,
                zip,
                country
        );

        // Fill in Birthdate & Gender
        addClient.enterBirthdate(birthdate);
        addClient.selectGender(gender);

        // Fill in Contact Information
        addClient.enterContactInfo(
                phone,
                fax,
                mobile,
                email,
                website
        );

        // Fill in Taxes Info
        addClient.enterTaxInfo(
                vatId,
                taxCode
        );

        // Save the form
        addClient.clickSave();


        String actual = "";
        try {
            actual = driver.findElement(By.xpath(xpathActual)).getText();
        }
        catch (Exception e)
        {

        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,"This is not a dashboard");
    }


    @DataProvider
    public Object[][] getData() throws IOException {
        return getMyData("Data/AddClientFullData.xlsx","Clients");
    }
}
