package Login_temprory_file_just_for_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class login {
  public WebDriver driver;

   public login(WebDriver driver){

        this.driver=driver;

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

       //         https://portal-test.homeapphub.com/anonymous/signup/roofwrightlite




        // Enter email
        WebElement email=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='EmailAddress']")));
        email.sendKeys("peterwillo@gmail.com");

        // Enter password

        WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Password']")));
        password.sendKeys("Password1234");

        // Click on login button
        WebElement login=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-primary btn-block']")));
        login.click();


    }

}
