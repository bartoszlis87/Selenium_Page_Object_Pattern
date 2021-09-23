import PageObjects.LoginPage;
import PageObjects.OrderSuccessPage;
import PageObjects.StorePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ExamplePageObjects {

    WebDriver driver;
    String username = "standard_user";
    String password = "secret_sauce";
    StorePage storePage;

    @BeforeEach
    public void setupDriver() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver).goTo();
        storePage = loginPage.login(username, password);
    }

    @Test
    public void purchaseProductTest() {
        String expectedSuccessfulOrderText = "THANK YOU FOR YOUR ORDER\n" +
                "Your order has been dispatched, and will " +
                "arrive just as fast as the pony can get there!\n" +
                "BACK HOME";
        String customerName = "Bartek";
        String customerLastName = "Test";
        String customerPostalCode = "2212312222";
        String productName = "Sauce Labs Bolt T-Shirt";
        OrderSuccessPage successPage = storePage.addToCart(productName)
                .goToCart()
                .goToCheckout()
                .fillInCustomerData(customerName, customerLastName,
                        customerPostalCode)
                .goToOrderSummary()
                .goToPayment();
        Assertions.assertEquals(expectedSuccessfulOrderText,
                successPage.getSuccessMessage(),
                "Order confirmation message is different than expected.");
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

}
