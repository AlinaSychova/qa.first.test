package qa.sychova.alina;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {

        private static WebDriver driver;

        @BeforeClass
        public static void setup() {
            System.setProperty("webdriver.chrome.driver", "/home/alina/Work/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://accounts.google.com/signin");
        }


        @Test
    public void userLogin () {

            WebElement loginField = driver.findElement(By.id("identifierId"));
            loginField.sendKeys("mytestaccqa@gmail.com");

            WebElement loginButton = driver.findElement(By.id("identifierNext"));
            loginButton.click();

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("mytestaccqa1");

        WebElement nextButton = driver.findElement(By.id("passwordNext"));
        loginButton.click();

           /* WebElement profileUser = driver.findElement(By.cssSelector("gb_b gb_eb gb_R")); //maybe other
            String mailUser = profileUser.getText();
            Assert.assertEquals("mytestaccqa@gmail.com", mailUser); */

        }


            @AfterClass
            public static void tearDown() {
                WebElement menuUser = driver.findElement(By.cssSelector("gb_b gb_eb gb_R")); //maybe other
                menuUser.click();
                WebElement logoutButton = driver.findElement(By.id("gb_71"));
                logoutButton.click();
                driver.quit();
            }

}
