package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {




    public Menu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//a[normalize-space()='Dashboard']")
    WebElement dashboard;

    @FindBy(xpath = "//span[normalize-space()='Clients']")
    WebElement clients;

    @FindBy(xpath = "//a[contains(text(),'Add Client')]")
    WebElement addClient;

    @FindBy(xpath = "//a[normalize-space()='View Clients']")
    WebElement viewClients;

    @FindBy(xpath = "//span[normalize-space()='Quotes']")
    WebElement quotes;

    @FindBy(xpath = "//a[@class='create-quote']")
    WebElement createQuote;

    @FindBy(xpath = "//a[normalize-space()='View Quotes']")
    WebElement viewQuotes;

    // Actions
    public void clickDashboard() {
        dashboard.click();
    }

   /* public void openClientsMenu() {
        clients.click();
    }*/

    public void clickAddClient() {
        clients.click();
        addClient.click();
    }

    public void clickViewClients() {
        clients.click();
        viewClients.click();
    }

/*
    public void openQuotesMenu() {
        quotes.click();
    }
*/

    public void clickCreateQuote() {
        quotes.click();
        createQuote.click();
    }

    public void clickViewQuotes() {
        quotes.click();
        viewQuotes.click();
    }


}
