package Screenshotforprice;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class screenshot {

    public WebDriver driver;


    public screenshot(WebDriver driver){
        this.driver=driver;



        // Capture screenshot
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define the folder to save the screenshot
        String screenshotFolderPath = "C:\\Users\\Admin\\Desktop";

        // Create a Path for the destination folder
        Path destinationPath = Path.of(screenshotFolderPath);

        // Save the screenshot to the folder
        try {
            // Append the screenshot file name to the destination path
            destinationPath = destinationPath.resolve("screenshot.png");

            // Copy the screenshot file to the destination folder
            Files.copy(screenshotFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved: " + destinationPath);
        } catch (IOException e) {
            System.err.println("Error saving screenshot: " + e.getMessage());
        }


    }
}


