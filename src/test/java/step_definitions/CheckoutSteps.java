package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.pageObject.CartPage;
import org.example.pageObject.CheckoutPage;
import org.example.pageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CheckoutSteps {

    private WebDriver webDriver;

    public CheckoutSteps(){
        super(); //utk mengeksekusi Hooks/indukan
        this.webDriver = Hooks.webDriver;
    }

    @Then("User already on Checkout Overview Page")
    public void verifyCheckoutOverview(){
        CheckoutPage checkoutPage = new CheckoutPage(webDriver);
        Assert.assertTrue(checkoutPage.verifyCheckoutOverview());
    }

    @When("User input \"(.*)\" as a firstName, input \"(.*)\" as lastName and input \"(.*)\" as postCode")
    public void inputCredential(String firstName, String lastName, String postalCode) {
        CheckoutPage checkoutPage = new CheckoutPage(webDriver);
        checkoutPage.setFirstName(firstName);
        checkoutPage.setLastName(lastName);
        checkoutPage.setPostalCode(postalCode);
    }

    @And("User click Continue Button")
    public void clickContinue() throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage(webDriver);
        checkoutPage.ContinueCheckout();
        Thread.sleep(3000);
    }
}
