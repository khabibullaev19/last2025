package part2.com.soucedemo.tests.products;

import com.saucedemo.pages.ProductsPage;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import part2.com.soucedemo.base.BaseTest;

public class ProductsTest extends BaseTest {

    @Test
    public void testProductsHeaderIsDisplayed() {
        ProductsPage productsPage = logInPage.
                logIntoApplication("standard_user","secret_sauce");
        assertTrue(productsPage.isProductsHeaderDisplayed(),
                "\n Products Header Is Not Displayed \n");
    }

}
