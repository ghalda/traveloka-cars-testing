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
    private WebElement checkoutOverview;

    public boolean verifyCheckoutOverview(){
        return checkoutOverview.isDisplayed();
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

}
