package sit707_week2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void officeworks_registration_page(String url) {
        // Step 1: Locate chrome driver folder in the local drive.
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\manav\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Step 2: Use above chrome driver to open up a chromium browser.
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();

        System.out.println("Driver info: " + driver);

        sleep(2);

        // Load a webpage in chromium browser.
        driver.get(url);

        /*
         * How to identify a HTML input field - Step 1: Inspect the webpage, Step 2: locate
         * the input field, Step 3: Find out how to identify it, by id/name/...
         */
        driver.manage().window().maximize();

     // Find first input field which is firstname
        By firstName = RelativeLocator.with(By.tagName("input")).above(By.id("lastname"));
        WebElement fName = driver.findElement(firstName);
        fName.sendKeys("Manav");
        By lastName = RelativeLocator.with(By.tagName("input")).below(By.id("firstname"));
        WebElement lName = driver.findElement(lastName);
        lName.sendKeys("Mehta");
        By pNumber = RelativeLocator.with(By.tagName("input")).below(By.id("lastname"));
        WebElement phoneNumber = driver.findElement(pNumber);
        phoneNumber.sendKeys("0481006825");
        By mail = RelativeLocator.with(By.tagName("input")).below(By.xpath("//*[@id=\"phoneNumber\"]"));
        WebElement email = driver.findElement(mail);
        email.sendKeys("manavmehtaxyz@gmail.com");
        By pass = RelativeLocator.with(By.tagName("input")).below(By.id("email"));
        WebElement password = driver.findElement(pass);
        password.sendKeys("Manav@123");
        By cPass = RelativeLocator.with(By.tagName("input")).below(By.id("password"));
        WebElement rPass = driver.findElement(cPass);
        rPass.sendKeys("Manav@123");
        /*
        * Identify button 'Create account' and click to submit using Selenium API.
        */
        // Write code
        By eKey = RelativeLocator.with(By.tagName("button")).below(By.xpath("/html/body/div[2]/div/div[1]/div/div/form/div[10]/div/button[1]"));
        WebElement enterKey = driver.findElement(eKey);
        enterKey.click();
        sleep(3);
        /*
        * Take screenshot using selenium API.
        */
        // Write code
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Users\\manav\\Desktop\\Selenium Screenshot\\Screen2.png"));
        // Sleep a while
        sleep(2);
        driver.close();
        }
}