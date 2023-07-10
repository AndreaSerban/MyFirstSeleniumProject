package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLogin {

    @Test
    public void negativeLoginTest (){
        // open page
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        driver.manage().window().maximize();

        // enter username
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("tomsmith");

        // enter password
        WebElement passwordImput = driver.findElement(By.name("password"));
        passwordImput.sendKeys("incorect");

        // click login
        //WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
        //WebElement loginButton = driver.findElement(By.tagName("button"));
        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();

        //verificare
        WebElement errorAlert = driver.findElement(By.id("flash"));
        Assert.assertFalse(errorAlert.getText().contains("Your username is invalid!"));

        // inchidere driver
        driver.close();

    }
}
