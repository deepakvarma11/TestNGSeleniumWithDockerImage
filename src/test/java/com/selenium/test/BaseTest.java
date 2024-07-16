package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    WebDriver driver;

    @Test(dataProvider = "getDataBrowser")
    public void launch(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.name("q")).sendKeys("Deepak varma battini");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        System.out.printf(driver.getTitle());
    }


    @DataProvider(parallel = true)
    public Object[][] getDataBrowser() {
        return
                new Object[][]{{"chrome"}, {"firefox"}};
    }
}
