package regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import pages.AddClient;

public class AddClientTest {
    WebDriver driver;

    @BeforeClass
    public void doLogin() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/ip");

        Login login = new Login(driver);
        login.setTxtUsername("amolujagare@gmail.com");
        login.setTxtPassword("admin123");
        login.clickLogin();
    }

    @Test
    public void addClientTest() {
        // Navigate to Add Client Page
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        // Create AddClientPage object
        AddClient addClient = new AddClient(driver);

   /*     // Fill in Personal Information
        addClient.enterClientName("Ravi");
        addClient.enterClientSurname("Sharma");*/

        // (Language can be selected here later if needed)
         addClient.selectLanguage("English");  // To be handled later

       // Fill in Address
        addClient.enterAddress(
                "123 MG Road",      // Address line 1
                "Near Central Mall", // Address line 2
                "Pune",             // City
                "Maharashtra",      // State
                "411001",           // Zip
                "India"                  // Country (ignored for now)
        );
        addClient.enterBirthdate("05-Sep-1985");

  /*       // Fill in Contact Information

        // (Gender and Birthdate can be selected here later)
         addClient.selectGender("Female");

        addClient.enterContactInfo(
                "020-2456789",         // Phone
                "020-2456790",         // Fax
                "9876543210",          // Mobile
                "ravi.sharma@test.com", // Email
                "www.ravisharma.com"   // Website
        );




        // Fill in Taxes Info
        addClient.enterTaxInfo(
                "GSTIN1234XYZ", // VAT ID
                "PAN1234ABC"    // Tax Code
        );
*/
        // Save the form
      //  addClient.clickSave();
    }
}
