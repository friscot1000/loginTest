package com.android.webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


/**
 *
 */
public class loginTest {

    private static AndroidDriver driver;


    /**
     * setup.
     */
    @Before
    public void setup()
    {
        //Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "vbox86p");
        caps.setCapability("udid", "192.168.57.101:5555");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "5.1.0");
        caps.setCapability("appPackage", "co.bird.android");
        caps.setCapability("appActivity", "co.bird.android.app.feature.magiclink.activity.MagicLinkIntroActivity");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("noReset", "true");
        caps.setCapability("exported", "true");

        //Instantiate Appium Driver
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Appium SetUp for Android is successful and Appium Driver is launched successfully");
    }

    /**
     * teardown.
     */
    @After
    public void teardown()
    {
        driver.closeApp();
        driver.quit();
    }

    /**
     * test email login.
     * @throws Exception
     */
    @Test
    public void testCorrectEmail() throws Exception {
        System.out.println("<--------entering email--------->");
        Thread.sleep(1000);
        driver.findElement(By.id("co.bird.android:id/emailEditor")).sendKeys("fcontreras88+testing@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("co.bird.android:id/rideButton")).click();
        Thread.sleep(10000);
        String check_your_email = driver.findElement(By.id("co.bird.android:id/titleText")).getText();
        System.out.println("<--------verifying --------->");
        System.out.println(check_your_email);
        System.out.println("<--------------------------->");
        Assert.assertEquals("CHECK YOUR EMAIL", check_your_email);
    }

    /**
     * test error message when incorrect email is provided.
     * @throws Exception
     */
    @Test
    public void testWrongEmail() throws Exception
    {
        System.out.println("<--------entering invalid email--------->");
        Thread.sleep(1000);
        driver.findElement(By.id("co.bird.android:id/emailEditor")).sendKeys("testing");
        Thread.sleep(1000);
        String error_message = driver.findElement(By.id("co.bird.android:id/emailEditor")).getText();
        System.out.println("<----------------->");
        System.out.println(error_message);
        System.out.println("<----------------->");
//        assertEquals("000", error_message);
//        Assert.assertEquals();
    }

    /**
     * test error message when no email is provided.
     * @throws Exception
     */
    @Test
    public void testEmptyEmail() throws Exception
    {
        System.out.println("<--------entering empty email--------->");
        Thread.sleep(1000);
        driver.findElement(By.id("co.bird.android:id/emailEditor")).clear();
        driver.findElement(By.id("co.bird.android:id/rideButton")).click();
    }

}
