package Signup3;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Signup3 {
    public WebDriver driver;


    public Signup3(WebDriver driver) throws InterruptedException {
        this.driver = driver;

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Clear the password field and enter only numeric password
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='password']")));
        password.clear();
        Thread.sleep(1500);
        password.sendKeys("123456789");

        // Click on Signup button
        WebElement signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='myBtn']")));
        js.executeScript("arguments[0].click();", signup);

        //Scroll to password
        Thread.sleep(3000);
        WebElement password2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='password']")));
        js.executeScript("arguments[0].scrollIntoView();", password2);

        // Enter password again
        WebElement password3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='password']")));
        password3.sendKeys("Password1234");

    }

}
