package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up the WebDriver and configure the browser
        System.setProperty("webdriver.chrome.driver", "C:/Users/User/Desktop/Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.opencart.com/"); // Replace with the actual URL of your website
    }

    @Test
    public void testInvalidLogin() throws InterruptedException {
        // The user is on the main page of the website and gets the title of the page
        System.out.println("The user is on the main page: " + driver.getTitle());

        // The user will click on Account
        Thread.sleep(3000);
        WebElement account = driver.findElement(By.xpath("//*[@id=\"navbar-collapse-header\"]/div/a[2]"));
        account.click();
        Thread.sleep(3000);

        // Add assertions to verify the expected outcomes, if any
    }

    private void enterInvalidCredentials(String username, String password) throws InterruptedException {
        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"loginFrm_loginname\"]"));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"loginFrm_password\"]"));
        passwordField.sendKeys(password);
        Thread.sleep(3000);
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
