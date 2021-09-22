import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindByExampleTest {

    WebDriver driver;

    @FindBy(id="user-name")
    WebElement usernameField;
    @FindBy(id="password") WebElement passwordField;
    @FindBy(id="login-button") WebElement loginButton;
    @FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt") WebElement TshirtAddToCartButton;
    @FindBy(id="shopping_cart_container") WebElement cartIconLink;
    @FindBy(id="checkout") WebElement checkoutButton;
    @FindBy(id="first-name") WebElement firstNameField;
    @FindBy(id="last-name") WebElement lastNameField;
    @FindBy(id="postal-code") WebElement postalCodeField;
    @FindBy(id="continue") WebElement continueButton;
    @FindBy(id="finish") WebElement finishButton;
    @FindBy(id="checkout_complete_container") WebElement checkoutCompleteContainer;

    String username = "standard_user";
    String password = "secret_sauce";


    @BeforeEach
    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        PageFactory.initElements(driver, this);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    @Test
    public void purchaseProductTest(){
        String expectedSuccesfulOrderText = "THANK YOU FOR YOUR ORDER\n" +
                "Your order has been dispatched, and will " +
                "arrive just as fast as the pony can get there!\n" +
                "BACK HOME";
        String customerName = "Bartek";
        String customerLastName = "Testtt";
        String customerPostalCode = "2222wer2";
        TshirtAddToCartButton.click();
        cartIconLink.click();
        checkoutButton.click();
        firstNameField.sendKeys(customerName);
        lastNameField.sendKeys(customerLastName);
        postalCodeField.sendKeys(customerPostalCode);
        continueButton.click();
        finishButton.click();
        Assertions.assertEquals(expectedSuccesfulOrderText,
                checkoutCompleteContainer.getText(),
                "Order confirmation message is different than expected.");
    }
    @AfterEach
    public void quitDriver(){
        driver.quit();
    }


}
