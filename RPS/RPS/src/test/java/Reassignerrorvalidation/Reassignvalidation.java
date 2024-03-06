package Reassignerrorvalidation;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Reassignvalidation {
    public WebDriver driver;


    public Reassignvalidation(WebDriver driver) throws InterruptedException {
        this.driver = driver;

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;




        // 1st time error validation test    "When email and name field both empty"


        // Scroll to 'Action' button
        WebElement action=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dropdownMenuButton']")));
        js.executeScript("arguments[0].scrollIntoView();", action);
        Thread.sleep(800);
        action.click();
        // Select 'Reassign' from Action dropdowm
        WebElement reassign=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnReassignSeat']")));
        reassign.click();
        // Check error validation when both text boxes are empty
        // Click on 'Reassign license' button without any details
        WebElement resaasignlicense=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='btnReassignSeat'])[2]")));
        resaasignlicense.click();
        // Check validation when one text box is empty
        // First scroll to 'Action button
        Thread.sleep(800);



        //2nd time        " When Email is entered one time  and then leave Email text box empty and name is entered"


        //We have to initialize the locators again because of element stale element issue
        WebElement action1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dropdownMenuButton']")));
        js.executeScript("arguments[0].scrollIntoView();", action1);
        // Re-click on action button and select 'Reassign button
        action1.click();
        Thread.sleep(700);
        // again intialize reassign
        WebElement reassign1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnReassignSeat']")));
        reassign1.click();
        // Enter detail in Email section
        WebElement email=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ReassignedUserEmail']")));
        email.sendKeys("asdbaaiasd@yahoo.com");
        // click on reassign button
        WebElement resaasignlicense1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='btnReassignSeat'])[2]")));
        resaasignlicense1.click();
        // Now leave empty the email text field
        // Scroll to Action and perform the previous actions
        WebElement action2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dropdownMenuButton']")));
        js.executeScript("arguments[0].scrollIntoView();", action2);
        action2.click();
        // Re-locate resassign button
        WebElement reassign2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnReassignSeat']")));
        reassign2.click();
        // Enter text in name field
        WebElement name=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@placeholder='New user name'])[2]")));
        name.sendKeys("William ford");
        // reassignlicense  button click
        Thread.sleep(700);
        WebElement resaasignlicense2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='btnReassignSeat'])[2]")));
        resaasignlicense2.click();




        //3rd time     " When We enter wrong email and name is entered


        // Action functionality
        WebElement action3=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dropdownMenuButton']")));
        js.executeScript("arguments[0].scrollIntoView();", action3);
        action3.click();
        // reassign functionality
        Thread.sleep(700);
        WebElement reassign3=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnReassignSeat']")));
        reassign3.click();
        //Enter invalid email
        WebElement email1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ReassignedUserEmail']")));
        email1.sendKeys("aoishdioahoa");
        // enter name
        WebElement name1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@placeholder='New user name'])[2]")));
        name1.sendKeys("Jev");
        // Reassignlicense functionality
        Thread.sleep(700);
        WebElement resaasignlicense3=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='btnReassignSeat'])[2]")));
        resaasignlicense3.click();

    }
}
