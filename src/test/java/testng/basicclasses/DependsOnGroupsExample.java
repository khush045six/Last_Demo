package testng.basicclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DependsOnGroupsExample {
    public static WebDriver driver;
   @BeforeMethod(groups = {"smoke"})
    public void openWebpage(){
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        Assert.assertEquals("https://www.google.com/","https://www.google.com/");
    }
    @Test(groups = {"smoke"})
    public void searchTextBox() {
        Assert.assertTrue(true);
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));
        element.click();
        element.sendKeys("Automation Testing Course and Scope in India?");
        driver.close();

    }
    @Test(dependsOnGroups = {"smoke"})
    public void partiallinkText() throws InterruptedException {
        driver.findElement(By.xpath("//a[text()=' How Search works ']")).click();
        Thread.sleep(5000);
        driver.close();
    }
}
