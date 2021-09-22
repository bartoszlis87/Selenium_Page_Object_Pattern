import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ExtractItemsBeyondTest {

    WebDriver driver;
    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By tShirtAddToCartButton = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By cartIconLink = By.id("shopping_cart_container");
    By checkoutButton = By.id("checkout");
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By continueButton = By.id("continue");
    By finishButton = By.id("finish");
    By checkoutCompleteContainer = By.id("checkout_complete_container");
    String username = "standard_user";
    String password = "secret_sauce";

    @BeforeEach
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @Test
    public void purchaseProductTest() {
        String expectedSuccesfulOrderText = "THANK YOU FOR YOUR ORDER\n" +
                "Your order has been dispatched, and will " +
                "arrive just as fast as the pony can get there!\n" +
                "BACK HOME";
        String customerName = "Bartek";
        String customerLastName = "Test";
        String customerPostalCode = "123355643";
        driver.findElement(tShirtAddToCartButton).click();
        driver.findElement(cartIconLink).click();
        driver.findElement(checkoutButton).click();
        driver.findElement(firstNameField).sendKeys(customerName);
        driver.findElement(lastNameField).sendKeys(customerLastName);
        driver.findElement(postalCodeField).sendKeys(customerPostalCode);
        driver.findElement(continueButton).click();
        driver.findElement(finishButton).click();
        Assertions.assertEquals(expectedSuccesfulOrderText,
                driver.findElement(checkoutCompleteContainer).getText(),
                "Order confirmation message is different than expected.");
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

}
