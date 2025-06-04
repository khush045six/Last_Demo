package testng.parameterization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Data_ProviderExample {

    @DataProvider(name = "test-data")
    public Object[][] dataSet(){
        return new Object[][]{
                {"SELENIUM"},{"Automation Testing"},{"Driving License"}
        };
    }
    @Test(dataProvider = "test-data")
    public void dataProviderExample(String Name) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebElement textBox = driver.findElement(By.xpath("//input[@id='enabled-example-input']"));
        textBox.click();
        textBox.sendKeys(Name);
        Thread.sleep(3000);
        driver.close();
    }
}
