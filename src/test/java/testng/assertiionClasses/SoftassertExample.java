package testng.assertiionClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SoftassertExample {
    SoftAssert ast = new SoftAssert();
    public static WebDriver driver;
    @Test(description = "Verify BMW radio button,Enabled TextBox,PracticepageText On Practice")
    public void verifyPracticePage(){
        driver = new ChromeDriver();
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement enabledBox = driver.findElement(By.xpath("//input[@id='enabled-example-input']"));
        ast.assertTrue(enabledBox.isEnabled(),"TextBox Is Enabled");
        WebElement radioButtons = driver.findElement(By.xpath("//input[@id='bmwradio']"));
        ast.assertFalse(radioButtons.isSelected(),"BMW is not Selected byDefault.");
        WebElement TextDisplay = driver.findElement(By.xpath("//h1[text()='Practice Page']"));
        ast.assertEquals(TextDisplay.getText(),"Practice Page","Text should be displayed.");
        ast.assertAll();
        driver.close();
    }
}
