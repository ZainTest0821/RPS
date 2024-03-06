package Paybycard2;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Paybycard2 {

    public WebDriver driver;


    public Paybycard2(WebDriver driver) throws InterruptedException {
        this.driver = driver;

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Make card number field empty
        //Switch to frame
        driver.switchTo().frame(0);

        WebElement cardnumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='Card number']")));
        cardnumber.clear();

        // Switch to default content
        driver.switchTo().defaultContent();

        // Click on subscribe button
        WebElement subscribe = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='subscribeBtn']")));
        subscribe.click();

        // Again enter card number again
        //Switch to frame
        driver.switchTo().frame(0);
        cardnumber.sendKeys("4000000000003220");

        // Switch to default content
        Thread.sleep(800);
        driver.switchTo().defaultContent();
        // Click on subscribe button again
        subscribe.click();

        //Switch to frame
        driver.switchTo().frame(0);

        // Clear the CVV field on card details
        WebElement cvv = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='CVV']")));
        cvv.clear();

        // Switch to default content
        Thread.sleep(800);
        driver.switchTo().defaultContent();

        //Click on subscribe button again
        subscribe.click();

        // Enter value in CVV field
        //Switch to frame
        driver.switchTo().frame(0);
        Thread.sleep(800);
        cvv.sendKeys("078");

        // Switch to default content
        Thread.sleep(800);
        driver.switchTo().defaultContent();
        //Click on subscribe button again
        subscribe.click();
    }
}
