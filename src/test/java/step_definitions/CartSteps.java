package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.pageObject.CartPage;
import org.example.pageObject.SalesPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CartSteps {

    private WebDriver webDriver;

    public CartSteps(){
        super(); //utk mengeksekusi Hooks/indukan
        this.webDriver = Hooks.webDriver;
    }

    @Then("User already on cart page")
    public void verifyCartPage(){
        CartPage cartPage = new CartPage(webDriver);
        Assert.assertTrue(cartPage.verifyCartPage());
    }

    @When("User remove product \"(.*)\"")
    public void removeProduct(String namaProduct) {
        CartPage cartPage = new CartPage(webDriver);
        cartPage.removeProduct(namaProduct);
    }

    @And("User click checkout button")
    public void clickButtonCheckout() {
        CartPage cartPage = new CartPage(webDriver);
        cartPage.clickCheckout();
    }
}
