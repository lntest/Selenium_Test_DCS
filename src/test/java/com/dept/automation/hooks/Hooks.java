package com.dept.automation.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;
    @Before
    public void init(Scenario scenario){
        if (scenario.getSourceTagNames().contains("@ui")) {
            System.out.println("Running ui tests");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            // Implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    @After
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
