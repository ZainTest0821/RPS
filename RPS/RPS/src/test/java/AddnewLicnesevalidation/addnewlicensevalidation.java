package AddnewLicnesevalidation;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class addnewlicensevalidation {

    public WebDriver driver;


  public addnewlicensevalidation(WebDriver driver)  {
    this.driver = driver;



    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(20))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class);
    JavascriptExecutor js = (JavascriptExecutor) driver;
        // 1st error validation test           "When both fields are empty on Add new license dialog-box"


        // Scroll to 'Add new license and click
        WebElement addlicense=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btncreateSeat']")));
        js.executeScript("arguments[0].scrollIntoView();",addlicense);
        addlicense.click();
        // Check the cross button
        WebElement cross=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='close']")));
        cross.click();
        addlicense.click();
        // Click on 'Create license' without entering any data and check error validation
        WebElement createlicense=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCreateSeat']")));
        createlicense.click();


        // 2nd                 "Test when the email is enter and name is empty"


        // Scroll to 'Add new license' and click on it
        WebElement addlicense1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btncreateSeat']")));
        js.executeScript("arguments[0].scrollIntoView();",addlicense1);
        addlicense1.click();
        //Enter email
        WebElement email=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='NewUserEmail']")));
        email.sendKeys("casimev850@weizixu.com");
        // Click on createlicense button again, and we have to again initialize the locator due to stale element because page refresh
        WebElement createlicense1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCreateSeat']")));
        createlicense1.click();


        // 3rd                     "Now enter Name and leave the email field empty"



        // Scroll to Add new license
        WebElement addlicense2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btncreateSeat']")));
        js.executeScript("arguments[0].scrollIntoView();",addlicense2);
        addlicense2.click();
        // Enter name and leave the email field empty
        WebElement name=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='NewUserName']")));
        name.sendKeys("Berlin");
        // Click on 'Create new license'
        WebElement createlicense2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCreateSeat']")));
        createlicense2.click();



        // 4th               Test when email is invalid


        // Do Scroll and other actions
        WebElement addlicense3=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btncreateSeat']")));
        js.executeScript("arguments[0].scrollIntoView();",addlicense3);
        addlicense3.click();
        //Enter email
        WebElement email2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='NewUserEmail']")));
        email2.sendKeys("lhjhjkhhhlklk");
        // Enter name and leave the email field empty
        WebElement name1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='NewUserName']")));
        name1.sendKeys("Berlin");
        // Click on 'Create new license'
        WebElement createlicense3=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCreateSeat']")));
        createlicense3.click();

    }
}
