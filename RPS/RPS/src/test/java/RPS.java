import AddnewLicnesevalidation.addnewlicensevalidation;
import Paybycard2.Paybycard2;
import Reassignerrorvalidation.Reassignvalidation;
import Screenshotforprice.screenshot;
import Signup2.Signup2;
import Signup3.Signup3;
import Signup4.Signup4;
import Singup.Signup;
import Testdatacheck.testdatacheck;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class RPS {

    WebDriver driver;


    @BeforeTest
    public void LaunchBrowser() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get(" https://portal-test.homeapphub.com/anonymous/signup/roofwrightlite");

    }

  @Test(priority = 1)
        // TC NO: 2
    void Signup1() {
        // Use Page object model `POM`
        PageFactory.initElements(driver, Signup.class);
    }

    @Test(priority = 2)
    void Signup2() {
        // TC NO : 03
        PageFactory.initElements(driver, Signup2.class);
    }

    @Test(priority = 3)
    void Signup3(){
        // TC No: 4
        PageFactory.initElements(driver, Signup3.class);
    }

    @Test(priority = 4)
    void Signup4(){
        // TC No: 05 and 6
        PageFactory.initElements(driver, Signup4.class);
    }

    @Test(priority = 5)
    void Sinup5() {
        // TC NO 07 and 08
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Click on Signup button
        WebElement signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='myBtn']")));
        js.executeScript("arguments[0].click();", signup);

        // Click on link from confirmation text window
        WebElement confirmation = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("https://portal-test.homeapphub.com/Anonymous/Subscribe/roofwrightlite/")));
        js.executeScript("arguments[0].click();", confirmation);

    }

    @Test(priority = 6)
        // TC NO 9 , 10 , 11 and 12
    void Paybycard() throws InterruptedException {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Click on 'Pay by card' button
        WebElement paybycard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-link']")));
        js.executeScript("arguments[0].click();", paybycard);

        //Switch to frame
        driver.switchTo().frame(0);

        // Enter card number
        WebElement cardnumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='Card number']")));
        cardnumber.sendKeys("4000000000003220");

        // Enter Expiry date
        WebElement expiry = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='MM / YY']")));
        expiry.sendKeys("0233");

        // Enter CVV
        WebElement cvv = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='CVV']")));
        cvv.sendKeys("0786");

        // Switch to default content
        driver.switchTo().defaultContent();

        // Enter name
        WebElement firstname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='First name']")));
        firstname.sendKeys("Peter");

        // Enter last name
        WebElement lastname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='Last name']")));
        lastname.sendKeys("Willson");

        // Enter Zipcode
        WebElement zipcode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='Postal code / ZIP Code']")));
        zipcode.sendKeys("34567");

        // Click on subscribe button
        WebElement subscribe = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='subscribeBtn']")));
        subscribe.click();

        // Empty name field
        firstname.clear();

        // Click on subscribe button again
        subscribe.click();

        // Enter value in firstname again
        Thread.sleep(1500);
        firstname.sendKeys("Peter");

        // Click on subscribe button again
        subscribe.click();

        // Clear the lastname text field value
        Thread.sleep(800);
        lastname.clear();

        // Click on Subscribe button
        Thread.sleep(800);
        subscribe.click();

        // Enter the value in lastname again
        lastname.sendKeys("Willson");

        // Enter the subscribe button agian
        subscribe.click();

    }

    @Test(priority = 7)
    void Paybycard2(){
        // TC NO 13
        PageFactory.initElements(driver, Paybycard2.class);
    }
    @Test(priority = 8)
    void testdatacheck(){
        // TC No 14
        PageFactory.initElements(driver, testdatacheck.class);
    }


    @Test(priority = 9)
    void testscripts() throws InterruptedException {
        // TC No 15
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Switch to frame
        driver.switchTo().frame(0);

        // Clear the values from card field and then re-enter valid details
        WebElement cardnumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='Card number']")));
        cardnumber.clear();
        //Enter valid details
        Thread.sleep(800);
        cardnumber.sendKeys("4111-1111-1111-1111");

        // Enter Expiry date
        WebElement expiry = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='MM / YY']")));
        expiry.clear();
        expiry.sendKeys("0635");

        // Enter CVV
        WebElement cvv = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='CVV']")));
       cvv.clear();
        cvv.sendKeys("567");


        // Switch to default content
        Thread.sleep(800);
        driver.switchTo().defaultContent();

        // Change the zip code to valid
        WebElement zipcode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='Postal code / ZIP Code']")));
        zipcode.clear();
        // wait and resend the new value
        Thread.sleep(800);
        zipcode.sendKeys("CO13 9AU");

        // Enter name
        WebElement firstname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='First name']")));
        firstname.clear();
        firstname.sendKeys("Alexander");

        // Enter last name
        WebElement lastname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='Last name']")));
        lastname.sendKeys("Thomos");


        // Click on subscribe button
        WebElement subscribe = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='subscribeBtn']")));
        subscribe.click();

    }

    /*@Test(priority = 10)
    void activationcode() throws InterruptedException {
        // TC No 16
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        // Wait to copy
        Thread.sleep(7000);

        // Go back to back screen
        driver.navigate().back();

        // Locate the activation code text field and paste the code using Actions class
        WebElement activationCodeField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='Coupon code']")));

        // Paste the link
        Actions actions = new Actions(driver);
        actions.moveToElement(activationCodeField).click().keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

        // Click on Apply
        WebElement apply=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='applyCouponCode']")));
        apply.click();

    }*/
    @Test(priority = 11)
    void linkchecking(){
        //TC No 17 & 18
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement linkcheck=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Click here to visit your subscription portal now")));
        linkcheck.click();

    }
    @Test(priority = 12)
    void productlink(){
        // TC N0 19 $ 20
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        // Click on link present in Product table
        WebElement linkinproduct=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("RoofWright Lite")));
        linkinproduct.click();
    }

    @Test(priority = 13)
    void reassignerrorvalidation() throws InterruptedException {
        // TC No 21
       PageFactory.initElements(driver, Reassignvalidation.class);
    }

    @Test(priority = 14)
    void reassignsucessfull(){
        // TC No 22
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Clear the email field and enter new value
        WebElement email=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ReassignedUserEmail']")));
        email.clear();
        email.sendKeys("asdbaai@yahoo.com"); // should be same as Signup email

        // Click on 'Reassign license' button
        WebElement resaasignlicense=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='btnReassignSeat'])[2]")));
        resaasignlicense.click();

    }

    @Test(priority = 15)
    void addnewlicense(){
        // TC No 23
      PageFactory.initElements(driver, addnewlicensevalidation.class);
    }

    @Test(priority = 16)
            void addnewlicensesuccessfull() throws InterruptedException {
        // Tc NO 24 and 25
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Add new value in email field
        WebElement email=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='NewUserEmail']")));
        email.clear();
        Thread.sleep(80);
        email.sendKeys("casimev850@weizixu.com");

        // Click on 'Create license
        WebElement createlicense=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCreateSeat']")));
        createlicense.click();

        Thread.sleep(2000);

        //Take screenshot for price
        PageFactory.initElements(driver, screenshot.class);

    }
@Test(priority = 17)
    void myaccount(){
    // TC NO 26
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(20))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class);

    // Click on 'My Account' button
    WebElement myaccount=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='nav-link'])[2]")));
    myaccount.click();
}
@Test(priority = 18)
    void changepaymentdetails() throws InterruptedException {
    // TC NO 27
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(20))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class);

    // Click on Change payment details button
    WebElement changepayment=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-primary btn-block']")));
    changepayment.click();

    // Click on Cancel button to check it is working fine
    WebElement cancel=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cancel']")));
    cancel.click();

    // Again initialize the locator because of setel element erroer
    Thread.sleep(800);
    WebElement changepayment1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-primary btn-block']")));
    changepayment1.click();


    // Change the card details
    //Switch to frame
    driver.switchTo().frame(0);

    // Clear the values from card field and then re-enter valid details
    WebElement cardnumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='Card number']")));
    cardnumber.clear();
    //Enter valid details
    Thread.sleep(800);
    cardnumber.sendKeys("4111-1111-1111-1111");
    // Enter Expiry date
    WebElement expiry = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='MM / YY']")));
    expiry.clear();
    expiry.sendKeys("0328");
    // Enter CVV
    WebElement cvv = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='CVV']")));
    cvv.clear();
    cvv.sendKeys("765");
    // Switch to default content
    Thread.sleep(800);
    driver.switchTo().defaultContent();
    // Enter name
    WebElement firstname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='First name']")));
    firstname.clear();
    firstname.sendKeys("Alexander");

    // Enter last name
    WebElement lastname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='Last name']")));
    lastname.sendKeys("Thomos");

    // Change the zip code to valid
    WebElement zipcode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='post_code']")));
    zipcode.clear();
    // wait and resend the new value
    Thread.sleep(800);
    zipcode.sendKeys("CO13 9AU");

    // Click on Update
    WebElement update=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='change-card-details']")));
    update.click();

}
@Test (priority = 19)
    void changenumnber() throws InterruptedException {
    // TC No 28
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(20))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class);

    // Click on 'Change Phone number' button
    WebElement phonenumber=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-primary']")));
    phonenumber.click();

    // Check cancel button
    WebElement cancel=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cancel']")));
    cancel.click();

    // Click on 'Change Phone number' button again
    WebElement phonenumber1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-primary']")));
    phonenumber1.click();

    // Check Country code selector dropdown
    WebElement countrycode=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='DialCode']")));
    countrycode.click();
    Thread.sleep(500);
    countrycode.click();

    // Change the 'Phone number
    WebElement changephonenumber=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='PhoneNumber']")));
    changephonenumber.clear();
    changephonenumber.sendKeys("1632 960907");

    // Click on update button
    WebElement update=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-primary btn-block']")));
    update.click();
}
@Test(priority = 20)
    void changepassword(){
    // TC No 29
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(20))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    // Scroll to password
    WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='btn btn-primary'])[2]")));
    js.executeScript("arguments[0].scrollIntoView();", password);
    password.click();

    // Check cancel button
    WebElement cancel=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cancel']")));
    cancel.click();

    // Again click on password and initialized the locator again because of refresh
    WebElement password1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='btn btn-primary'])[2]")));
    js.executeScript("arguments[0].scrollIntoView();", password1);
    password1.click();


    // Enter Value in 'New Password'
    WebElement newpassword=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Password']")));
    newpassword.sendKeys("Password1234");

    // Enter Value in 'Confirm Password
    WebElement confirmpassword=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ConfirmPassword']")));
    confirmpassword.sendKeys("Password1234");

    // Click on Update button
    WebElement update=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-primary btn-block']")));
    update.click();

}
@Test(priority = 21)
    void addcompany(){
    // TC NO 30
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(20))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    //Scroll to 'Add a company' button
    WebElement addcompany=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='btn btn-primary'])[3]")));
    js.executeScript("arguments[0].scrollIntoView();", addcompany);
    addcompany.click();

    // Check close button
    WebElement close=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='close']")));
    close.click();

    // Again click on add company
    WebElement addcompany1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='btn btn-primary'])[3]")));
    js.executeScript("arguments[0].scrollIntoView();", addcompany1);
    addcompany1.click();

    // Enter the name in Name field
    WebElement name=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='NewCompanyName']")));
    name.sendKeys("Wilson");

    // Click on update
    WebElement update=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnChangeCompanyName']")));
    update.click();

}
@Test(priority = 22)
    void Signout(){
    // TC No 31
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(20))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class);

    // Click on Signout button
    WebElement signout=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='nav-link'])[3]")));
    signout.click();
}

}

