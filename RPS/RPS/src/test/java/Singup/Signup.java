package Singup;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Signup {
    public WebDriver driver;


    public Signup(WebDriver driver) throws InterruptedException {
        // TC No:2
        this.driver = driver;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Click on 'Signup me' button
        WebElement signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='myBtn']")));
        // Scroll down to Signup button
        js.executeScript("arguments[0].scrollIntoView();", signup);
        js.executeScript("arguments[0].click();", signup);

        // Switch to alert and dismiss it
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        // Fill the checkbox
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='chkcondition']")));
        // scroll down to end and fill the checkbox
        js.executeScript("arguments[0].scrollIntoView();", checkbox);
        js.executeScript("arguments[0].click();", checkbox);

        // Again click on 'Sign up me' button to check error
        js.executeScript("arguments[0].click();", signup);

    }
}
