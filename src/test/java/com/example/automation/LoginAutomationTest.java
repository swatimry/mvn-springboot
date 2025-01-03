package com.example.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginAutomationTest {

    @Test
    void testLogin() {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the login page served by Spring Boot (change port if needed)
            driver.get("http://localhost:8081/login");  // Adjusted for your Spring Boot application

            // Locate the username and password fields and the login button on the login page
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

            // Perform login with correct credentials
            usernameField.sendKeys("tomsmith");
            passwordField.sendKeys("SuperSecretPassword!");
            loginButton.click();

            // Validate successful login by checking for the success message
            WebElement successMessage = driver.findElement(By.id("message"));  // Assuming the success message has id 'message'
            assertTrue(successMessage.getText().contains("You logged into a secure area!"), "Login success message not found");

            // Optional: Validate error message if incorrect credentials are entered
            // WebElement errorMessage = driver.findElement(By.id("error-message"));
            // assertTrue(errorMessage.getText().contains("Invalid username or password."), "Login error message not found");

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
