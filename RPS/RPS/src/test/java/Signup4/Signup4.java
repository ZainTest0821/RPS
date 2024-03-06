package Signup4;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Signup4 {
    public WebDriver driver;


    public Signup4(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Uncheck the terms and condition check-box
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='chkcondition']")));
        //js.executeScript("arguments[0].click();", checkbox);

        // Click on Signup button
        WebElement signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='myBtn']")));
        js.executeScript("arguments[0].click();", signup);


        // Switch to alert and dismiss the alert
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        // Check the terms and condition check-box
        Thread.sleep(1500);
        checkbox.click();

    }
}