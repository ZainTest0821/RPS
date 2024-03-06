package Testdatacheck;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.FileNotFoundException;
import java.time.Duration;


public class testdatacheck {

    public WebDriver driver;


    void testdata() throws FileNotFoundException, InterruptedException {
        this.driver = driver;

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;


        // Switch to frame
        //Switch to frame
        driver.switchTo().frame(0);

        // Clear the card values and then re-enter wrong card details check validation
        WebElement cardnumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='Card number']")));
        cardnumber.clear();
        Thread.sleep(800);
        //Insufficient funds card number
        cardnumber.sendKeys("4000-0000-0000-1190");

        // switch to default content
        driver.switchTo().defaultContent();

        //Change the zip code and re-enter new one
        WebElement zipcode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='post_code']")));
        zipcode.clear();
        // wait and resend the new value
        Thread.sleep(800);
        zipcode.sendKeys("OX7 6RZ");

        // Click on subscribe button
        WebElement subscribe = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='subscribeBtn']")));
        subscribe.click();

        Thread.sleep(5000);
        // Again Click on 'Pay by card' button
        WebElement paybycard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-link']")));
        js.executeScript("arguments[0].click();", paybycard);

        // Change the card number again
        // Switch to iframe
        driver.switchTo().frame(0);
        WebElement cardnumber1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='Card number']")));
        cardnumber1.sendKeys("4000-0000-0000-0051");

        // Enter Expiry date
        WebElement expiry = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='MM / YY']")));
        expiry.sendKeys("0133");

        // Enter CVV
        WebElement cvv = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='CVV']")));
        cvv.sendKeys("0788");

        // Switch to default content
        driver.switchTo().defaultContent();

        // Enter name
        WebElement firstname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='First name']")));
        firstname.sendKeys("John");

        // Enter last name
        WebElement lastname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='Last name']")));
        lastname.sendKeys("Sence");

        // Enter Zipcode
        WebElement zipcode1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='Postal code / ZIP Code']")));
        zipcode1.sendKeys("EN9 1QW");


        // Click on subscribe button again
        WebElement subscribe1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='subscribeBtn']")));
        subscribe1.click();

        // Switch to iframe
        driver.switchTo().frame(0);

        // Clear the card field  and again enter new one
        cardnumber1.clear();
        cardnumber1.sendKeys("4000-0000-0000-0325");

        // Change the cvv
        cvv.clear();
        Thread.sleep(500);
        cvv.sendKeys("0656");


        // Change the expiry
        expiry.clear();
        expiry.sendKeys("0828");


        // Switch to default content
        driver.switchTo().defaultContent();
        // change the first name
        firstname.clear();
        Thread.sleep(500);
        firstname.sendKeys("William");

        // Change the last name
        lastname.clear();
        Thread.sleep(500);
        lastname.sendKeys("Jack");

        // Change the zip code
        zipcode1.clear();
        zipcode1.sendKeys("BR5 1JL");

        // Click on subscribe button
        subscribe1.click();

    }

}
