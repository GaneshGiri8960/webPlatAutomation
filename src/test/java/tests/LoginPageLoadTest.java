package tests;
import org.example.pageObjects.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ExcelUtils;
import utils.ReportUtils;

public class LoginPageLoadTest extends BaseTest {
    @Test
    public void testPageLoadPerformance() {
        long startTime = System.currentTimeMillis();
        LoginPage loginPage = new LoginPage(driver);

        wait.until(ExpectedConditions.visibilityOf(loginPage.usernameField));
        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordField));
        wait.until(ExpectedConditions.visibilityOf(loginPage.signInButton));

        long endTime = System.currentTimeMillis();
        long totalTime = (endTime - startTime) / 1000; // Convert to seconds

        Assert.assertTrue(totalTime <= 30, "Page load took " + totalTime + " seconds, exceeding 30 seconds limit.");

        // Log time to HTML report (using ReportUtils)
        ReportUtils.log("Page load time: " + totalTime + " seconds");

        // Enter credentials and validate
        loginPage.enterUsername("9999999999");
        loginPage.enterPassword("Amitabh");
        loginPage.clickSignIn();
        Assert.assertTrue(loginPage.getInvalidMessage().contains("Invalid username or password"));

        // Update Excel with results
        ExcelUtils.updateResult("Test Case 1", "Page load time: " + totalTime + "s", "Pass", "screenshot/path", "report/path");
    }
}
