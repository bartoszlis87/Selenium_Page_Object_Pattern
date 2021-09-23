package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSuccessPage {
    WebDriver driver;
    @FindBy(id = "checkout_complete_container")
    WebElement
            checkoutCompleteContainer;

    public OrderSuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getSuccessMessage() {
        return checkoutCompleteContainer.getText();
    }
}
