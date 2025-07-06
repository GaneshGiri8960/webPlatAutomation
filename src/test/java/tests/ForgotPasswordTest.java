package tests;

import org.example.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ExcelUtils;

public class ForgotPasswordTest extends BaseTest {
    @Test
    public void testForgotPasswordFlow() {
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(loginPage.forgotPasswordLink.isDisplayed(), "Forgot password option not visible");

        loginPage.clickForgotPassword();
        loginPage.enterUsername("9999999999");
        loginPage.clickSendButton(); // Assuming "Send" button uses the same logic

        Assert.assertTrue(loginPage.getUsernameNotExistsMessage().contains("Username not exists"));

        // Update Excel with results
        ExcelUtils.updateResult("Test Case 3", "Forgot password flow validated", "Pass", "screenshot/path", "report/path");
    }
}
