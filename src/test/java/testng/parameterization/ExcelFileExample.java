package testng.parameterization;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class ExcelFileExample {
    @DataProvider(name = "test-data")
    public Object[][] dataSet() throws IOException {
        Object[][] arrObj = getExceldata("C:\\Users\\HP\\OneDrive\\Desktop\\TESTDATA.xlsx", "TD1");
        return arrObj;
    }

    public String[][] getExceldata(String fileName, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(fileName); //Normal File Access
        XSSFWorkbook wb = new XSSFWorkbook(file); // Excel File Access
        XSSFSheet sheet = wb.getSheet(sheetName);
        XSSFRow row = sheet.getRow(0);
        int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfColumns = row.getLastCellNum();



        Cell cell;
        String[][] data = new String[noOfRows - 1][noOfColumns];
        for(int i = 1; i < noOfRows-1; i++){
            for(int j = 0; j < noOfColumns; j++){
                row = sheet.getRow(i);
                cell = row.getCell(j);
                data[i-1][j] = cell.getStringCellValue();
            }
        }
      return data;


    }
    @Test(dataProvider = "test-data")
    public void verifyNeedOfParameterization(String cityName, String courseName) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement textBox = driver.findElement(By.xpath("//textarea[@name='q']"));
        textBox.click();
        textBox.sendKeys(cityName + " " + courseName);
        textBox.sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        driver.close();
    }
}
