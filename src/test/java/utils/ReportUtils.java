package utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ReportUtils {
    private static ExtentReports extent;
    private static ExtentTest test;

    static {
        extent = new ExtentReports();
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Browser", "Chrome");
    }

    public static void log(String message) {
        test = extent.createTest("Test Report");
        test.log(Status.INFO, message);
        extent.flush();
    }
}