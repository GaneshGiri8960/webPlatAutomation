package org.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver driver;

    @FindBy(xpath = "//*[@id='fullName']")
    public WebElement usernameField;

    @FindBy(xpath = "//*[@id='Password']")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@id='registerForm']/div/div[5]/div/button")
    public WebElement signInButton;

    @FindBy(xpath = "//a[text()='Forgot Password ?']")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//*[@id='main-wrapper']/div/div/div/div/div[2]/div/div/div[2]/form/div/div[4]/div/button")
    public WebElement sendButton;


    @FindBy(xpath = "//*[contains(text(), 'Invalid username or password')]")
    private WebElement invalidMessage;

    @FindBy(xpath = "//*[contains(text(), 'Username not exists')]")
    private WebElement usernameNotExistsMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSignIn() {
        signInButton.click();
    }

    public void clickForgotPassword() {
        forgotPasswordLink.click();
    }

    public void clickSendButton() {
        sendButton.click();
    }

    public String getInvalidMessage() {
        return invalidMessage.getText();
    }

    public String getUsernameNotExistsMessage() {
        return usernameNotExistsMessage.getText();
    }
}
