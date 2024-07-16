package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Firefox {

    WebDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), capabilities);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void test01(){
        driver.findElement(By.name("q")).sendKeys("Deepak varma battini");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        System.out.printf(driver.getTitle());
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
