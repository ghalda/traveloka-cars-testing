package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    public static WebDriver driver;

    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id='checkout_info_container']")
    private WebElement checkoutForm;

    public boolean verifyCheckoutForm(){
        return checkoutForm.isDisplayed();
    }

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCode;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueCheckout;

    public void setFirstName(String name){
        firstName.sendKeys(name);
    }

    public void setLastName(String name){
        lastName.sendKeys(name);
    }

    public void setPostalCode(String code){
        postalCode.sendKeys(code);
    }

    public void ContinueCheckout(){
        continueCheckout.click();
    }

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement subTotal;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    private WebElement taxTotal;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    private WebElement totalOrder;


    public void verifyCheckoutOverview(){
        subTotal.isDisplayed();
        taxTotal.isDisplayed();
        totalOrder.isDisplayed();
    }


    public void clickFinishButton(){
        String buttonFinish = "//button[@id='finish']";
        driver.findElement(By.xpath(buttonFinish)).isDisplayed();
        Float subTotalValue = Float.valueOf(subTotal.getText().replace("Item total: $", ""));
        Float taxValue = Float.valueOf(taxTotal.getText().replace("Tax: $", ""));
        Float totalOrderValue = Float.valueOf(totalOrder.getText().replace("Total: $", ""));

        if(subTotalValue + taxValue == totalOrderValue){
            driver.findElement(By.xpath(buttonFinish)).click();
        }

//        System.out.println(subTotalValue);
//        System.out.println(taxValue);
//        System.out.println(totalOrderValue);
//        System.out.println(subTotalValue + taxValue == totalOrderValue);
    }

    public void verifySuccessPage(){
        String completeHeader = "//h2[@class='complete-header']";
        driver.findElement(By.xpath(completeHeader)).isDisplayed();
    }
}
