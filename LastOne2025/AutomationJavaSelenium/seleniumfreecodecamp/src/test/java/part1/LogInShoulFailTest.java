package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogInShoulFailTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void testLoggingIntoApplication() throws InterruptedException {
        //The first way to assign and find the webelement
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        //The second way to assign and find the webelement
        // "var" is a Java keyword that infers the data type based on the "driver.findElement()
        //var password = driver.findElement(By.name("password")); --> is not working with my device, maybe java version issue(17 mine)
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        //The third way to assign and find the webelement
        // there is no object and object reference
        Thread.sleep(2000);
        driver.findElement(By.tagName("button")).click();

        Thread.sleep(2000);
        String actualResult = driver.findElement(By.tagName("h6")).getText();
        String expectedResult = "Dashboard";
        Assert.assertNotEquals(actualResult, expectedResult);
    }

}
