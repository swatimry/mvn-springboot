package com.example.automation;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginAutomationTest {

    @Test
    public void testLogin() {
        
        System.setProperty("webdriver.chrome.driver", "C://Program Files//chromedriver//chromedriver.exe");

        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); 
        
        

        WebDriver driver1 = new ChromeDriver(options);

        try {
            
            LoginPageAutomationSrc loginPage = new LoginPageAutomationSrc(driver);

            
            loginPage.openLogpage("https://the-internet.herokuapp.com/login");

            
            loginPage.setUsg_name("tomsmith");
            loginPage.setPwd("SuperSecretPassword!");
            loginPage.clickLoginButton();

            
            String successMessage = loginPage.getSuccessMsg();
            assertTrue(successMessage.contains("You logged into a secure area!"),
                    "Login  successful ");

        } finally {
            
            driver.quit();
        }
    }
}
