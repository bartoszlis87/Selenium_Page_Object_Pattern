package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {
    WebDriver driver;
    @FindBy(id = "finish")
    WebElement finishButton;

    public OrderSummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OrderSuccessPage goToPayment() {
        finishButton.click();
        return new OrderSuccessPage(driver);
    }
}
