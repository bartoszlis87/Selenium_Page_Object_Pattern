package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StorePage {
    WebDriver driver;
    @FindBy(id = "shopping_cart_container")
    WebElement cartIconLink;

    public StorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private WebElement getProductAddToCartButton(String productName) {
        WebElement productContainer =
                driver.findElement(By.xpath("//*[text() = '" + productName +
                        "']//ancestor::div[@class='inventory_item_description']"));
        return productContainer.findElement(By.cssSelector("button"));
    }

    public StorePage addToCart(String productName) {
        getProductAddToCartButton(productName).click();
        return this;
    }

    public CarPage goToCart() {
        cartIconLink.click();
        return new CarPage(driver);
    }
}
