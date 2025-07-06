package tests;

import org.example.pageObjects.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ExcelUtils;
import utils.ReportUtils;

public class InstagramRedirectTest extends BaseTest {
    @Test
    public void testInstagramRedirect() {
        LoginPage loginPage = new LoginPage(driver);

        if (!loginPage.forgotPasswordLink.isDisplayed()) {
            driver.findElement(By.xpath("//a[@href='https://instagram.com']")).click(); // Adjust XPath
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("instagram.com"), "Redirect to Instagram failed");

            // Update Excel with results
            ExcelUtils.updateResult("Test Case 4", "Redirected to Instagram", "Pass", "screenshot/path", "report/path");
        } else {
            ReportUtils.log("Forgot password option present, skipping Instagram redirect");
            ExcelUtils.updateResult("Test Case 4", "Skipped due to forgot password visibility", "N/A", "", "");
        }
    }
}