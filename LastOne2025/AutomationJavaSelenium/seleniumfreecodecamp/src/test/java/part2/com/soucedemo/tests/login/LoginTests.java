package part2.com.soucedemo.tests.login;

import com.saucedemo.pages.ProductsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import part2.com.soucedemo.base.BaseTest;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginErrorMessage() {
        logInPage.setUsername("standard_user");
        logInPage.setPassword("xyz3400");
        logInPage.clickLoginButton();
        String actualMessage = logInPage.getErrorMessage();
        Assert.assertFalse(actualMessage.contains("Epic sadface"));
    }

}
