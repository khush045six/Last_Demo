package testng.parameterization;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class NeedOfParameters {
    public static WebDriver driver;

    @Parameters({"browserName"})
    @BeforeMethod
    public void setUp(String browserName){
        if(browserName.equals("chrome")){
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        }else {
            System.out.println("Not Selected The Correct Browser.");
        }

    }
    @Parameters({"cityName","courseName"})
    @Test
    public void verifyNeedOfParameterization(String cityName, String courseName) throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement textBox = driver.findElement(By.xpath("//textarea[@name='q']"));
        textBox.click();
        textBox.sendKeys(cityName + " " + courseName);
        textBox.sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        driver.close();
    }
//    @Test
//    public void verifyPracticePage(){
//        driver.get("https://www.letskodeit.com/practice");
//        driver.manage().window().maximize();
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//        WebElement textBox = driver.findElement(By.xpath("//input[@id='enabled-example-input']"));
//        textBox.click();
//        driver.close();
//
//    }
}
