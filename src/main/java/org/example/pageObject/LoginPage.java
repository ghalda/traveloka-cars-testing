package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public static WebDriver driver;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private static WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement userPassword;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement btnLogin;

    @FindBy(xpath = "//h3")
    private WebElement errorText;

    public String verifyErrorText(){
        return errorText.getText();
    }

    public void setUserName(String name){
        userName.sendKeys(name); //variabel di class step definition
    }

    public void setPassword(String password){
        userPassword.sendKeys(password); //variabel di class step definition
    }

    public void clickLogin(){
        btnLogin.click(); //variabel di class step definition
    }

    public static boolean verifyLandingPage(){
        return userName.isDisplayed();
    }
}
