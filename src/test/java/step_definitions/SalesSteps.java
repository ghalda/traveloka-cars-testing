package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.pageObject.LoginPage;
import org.example.pageObject.SalesPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SalesSteps {

    private WebDriver webDriver;

    public SalesSteps(){
        super(); //utk mengeksekusi Hooks/indukan
        this.webDriver = Hooks.webDriver;
    }

    @Then("User already on sales page")
    public void verifySalesPage(){
        SalesPage salesPage = new SalesPage(webDriver);
        Assert.assertTrue(salesPage.verifySalesPage());
    }

    //Sort Product
    @When("User sort product list by \"(.*)\"")
    public void sortProduct(String sort) {
        SalesPage salesPage = new SalesPage(webDriver);
        salesPage.setSortProduct(sort);
    }

    //Using in Sales Feature
    @And("User add 2 product to cart")
    public void click2Product() {
        SalesPage salesPage = new SalesPage(webDriver);
        salesPage.clickProduct1();
        salesPage.clickProduct2();
    }

    //Using in Place Order Feature
    @And("User add \"(.*)\" and \"(.*)\" to cart")
    public void add2Product(String product1, String product2) {
        SalesPage salesPage = new SalesPage(webDriver);
        salesPage.addProduct1(product1);
        salesPage.addProduct2(product2);
    }

    @Then("User click icon cart")
    public void clickCart()  {
        SalesPage salesPage = new SalesPage(webDriver);
        salesPage.clickCart();
    }

    //    Alternatif Sort Product
//    @When("User set product by list Price low to high")
//    public void sortProduct() {
//        SalesPage salesPage = new SalesPage(webDriver);
//        salesPage.setSortProduct("Price (low to high)");
//    }

    //    Final Method for Add one Product
//    @And("User add product \"(.*)\"")
//    public void clickProduct(String namaProduct) throws InterruptedException {
//        SalesPage salesPage = new SalesPage(webDriver);
//        salesPage.productClick(namaProduct);
//    }
}
