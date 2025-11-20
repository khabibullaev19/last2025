package part2.com.soucedemo.base;

import com.saucedemo.pages.BasePage;
import com.saucedemo.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected BasePage basePage;
    protected LogInPage logInPage;
    private String url = "https://www.saucedemo.com/";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        basePage = new BasePage();
        basePage.setDriver(driver);
        logInPage = new LogInPage();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
