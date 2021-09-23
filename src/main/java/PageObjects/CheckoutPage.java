package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    @FindBy(id = "first-name")
    WebElement firstNameField;
    @FindBy(id = "last-name")
    WebElement lastNameField;
    @FindBy(id = "postal-code")
    WebElement postalCodeField;
    @FindBy(id = "continue")
    WebElement continueButton;
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CheckoutPage fillInCustomerData(String customerName, String
            customerLastName, String customerPostalCode) {
        firstNameField.sendKeys(customerLastName);
        lastNameField.sendKeys(customerLastName);
        postalCodeField.sendKeys(customerPostalCode);
        return this;
    }

    public OrderSummaryPage goToOrderSummary() {
        continueButton.click();
        return new OrderSummaryPage(driver);
    }
}
