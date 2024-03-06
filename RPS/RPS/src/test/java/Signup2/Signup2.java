package Signup2;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Signup2 {
    public WebDriver driver;


    public Signup2(WebDriver driver) throws InterruptedException {
        this.driver = driver;

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Enter name in 'Name' text field
        WebElement firstname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='FullName']")));
        firstname.sendKeys("Peter Willson");

        // Enter Email in email field
        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='EmailAddress']")));
        email.sendKeys("peterwilloc@gmail.com");   // change it everytime before running testcase

        // Enter password
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='password']")));
        password.sendKeys("Password1234");

        // Click on Signup button to check error
        WebElement signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='myBtn']")));
        js.executeScript("arguments[0].click();", signup);

        // Enter phone number
        WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='Phone number']")));
        phone.sendKeys("7911 123456");
        Thread.sleep(1500);
        firstname.clear();

        // Signup action again
        Thread.sleep(1500);
        signup.click();

        // Enter name and then click on Signup button
        Thread.sleep(1500);
        firstname.sendKeys("Peter Willson");

    }
}

