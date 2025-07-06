package utils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelUtils {
    public static void updateResult(String testCase, String actualResult, String status, String screenshotPath, String reportPath) {
        try {
            FileInputStream fis = new FileInputStream("test_results.xlsx");
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet("Results");

            Row row = sheet.createRow(sheet.getLastRowNum() + 1);
            row.createCell(0).setCellValue(testCase);
            row.createCell(1).setCellValue(actualResult);
            row.createCell(2).setCellValue(status);
            row.createCell(3).setCellValue(screenshotPath);
            row.createCell(4).setCellValue(reportPath);

            FileOutputStream fos = new FileOutputStream("test_results.xlsx");
            workbook.write(fos);
            fos.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
