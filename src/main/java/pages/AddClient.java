package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClient {

   WebDriver driver;

    // -------- Constructor --------
    public AddClient(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // -------- WebElements --------
    // Personal Information
    @FindBy(id = "client_name")
    WebElement clientName;

    @FindBy(id = "client_surname")
    WebElement clientSurname;

    @FindBy(id = "select2-client_language-container")
    WebElement languageContainer;

    // Address
    @FindBy(id = "client_address_1")
    WebElement clientAddress1;

    @FindBy(id = "client_address_2")
    WebElement clientAddress2;

    @FindBy(id = "client_city")
    WebElement clientCity;

    @FindBy(id = "client_state")
    WebElement clientState;

    @FindBy(id = "client_zip")
    WebElement clientZip;

    @FindBy(id = "select2-client_country-container")
    WebElement countryContainer;

    // Contact Information
    @FindBy(id = "client_phone")
    WebElement clientPhone;

    @FindBy(id = "client_fax")
    WebElement clientFax;

    @FindBy(id = "client_mobile")
    WebElement clientMobile;

    @FindBy(id = "client_email")
    WebElement clientEmail;

    @FindBy(id = "client_web")
    WebElement clientWeb;

    // Additional Personal Info
    @FindBy(id = "select2-client_gender-container")
    WebElement genderContainer;

    @FindBy(id = "client_birthdate")
    WebElement clientBirthdate;

    // Taxes
    @FindBy(id = "client_vat_id")
    WebElement clientVatId;

    @FindBy(id = "client_tax_code")
    WebElement clientTaxCode;

    // Buttons
    @FindBy(id = "btn-submit")
    WebElement btnSave;

    @FindBy(id = "btn-cancel")
    WebElement btnCancel;

    // -------- Actions --------
    public void enterClientName(String name) {

        clientName.sendKeys(name);
    }

    public void enterClientSurname(String surname) {

        clientSurname.sendKeys(surname);
    }
    @FindBy (xpath = "//input[@aria-label='Search']")
    WebElement search;

    public void selectLanguage(String lang) {
        languageContainer.click();
        search.sendKeys(lang);
        driver.findElement(By.xpath("//li[normalize-space()='"+lang+"']")).click();
    }

    public void setCountry(String country)
    {
        countryContainer.click();
        search.sendKeys(country);
        driver.findElement(By.xpath("//li[normalize-space()='"+country+"']")).click();
    }

    public void enterAddress(String address1, String address2, String city, String state, String zip, String country) {
        clientAddress1.sendKeys(address1);
        clientAddress2.sendKeys(address2);
        clientCity.sendKeys(city);
        clientState.sendKeys(state);
        clientZip.sendKeys(zip);
        setCountry(country);
    }

    public void enterContactInfo(String phone, String fax, String mobile, String email, String web) {
        clientPhone.sendKeys(phone);
        clientFax.sendKeys(fax);
        clientMobile.sendKeys(mobile);
        clientEmail.sendKeys(email);
        clientWeb.sendKeys(web);
    }

    public void selectGender(String gender) {
        genderContainer.click();
        driver.findElement(By.xpath("//li[normalize-space()='"+gender+"']")).click();
    }

    public void enterBirthdate(String birthdate) {
        // clientBirthdate.sendKeys(birthdate);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+birthdate+"')",clientBirthdate);
    }

    public void enterTaxInfo(String vatId, String taxCode) {
        clientVatId.sendKeys(vatId);
        clientTaxCode.sendKeys(taxCode);
    }

    public void clickSave() {
        btnSave.click();
    }

}