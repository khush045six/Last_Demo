package testng.basicclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class BasicsOfTestng {

    public static WebDriver driver;

    @BeforeMethod
    public void preCondition(){
         driver = new ChromeDriver();
         driver.manage().window().maximize();


    }

    @Test
    public void testCase1(){
        driver.get("https://www.google.com/");
        driver.navigate().refresh();

    }
    @Test
    public void testCase2(){
        driver.get("https://www.letskodeit.com/practice");

    }

    @AfterMethod
    public void postCondition(){

        driver.close();
    }
}
