import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTests {
    @Test
    public void purchaseProductTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"))
                .click();

        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Bartek");
        driver.findElement(By.id("last-name")).sendKeys("Test");
        driver.findElement(By.id("postal-code")).sendKeys("22222");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER\n" +
                        "Your order has been dispatched, and will " +
                        "arrive just as fast as the pony can get there!\n" +
                        "BACK HOME",
                driver.findElement(
//                        Krok 2: BeforeEach and AfterEach
//        Użycie adnotacji @BeforeEach oraz @AfterEach z JUnita do wyciągnięcia z
//        testu metod, które chcemy wykonywać przed i po każdym teście.
                By.id("checkout_complete_container")).getText(),
                "Order confirmation message is different than expected.");
        driver.quit();
    }
}
