package com.accesshq.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


public class IntroSelenium {
    private final String url = "https://d18u5zoaatmpxx.cloudfront.net/#/";

//   @Test
//    public void chromeBtnClickedTest(){
//       //Method 1 (old method -- might encounter security issues)
////       WebDriver chromeDriver = new ChromeDriver();
////       chromeDriver.get(url);
////       chromeDriver.findElement(By.id("forename")).sendKeys("Megatron");
////       chromeDriver.findElement(By.id("submit")).click();
//
//       //Method 2 (new method)
//       ChromeOptions options = new ChromeOptions();
//       options.addArguments("--allow-all-origin=*");
//       WebDriver chromeDriver = new ChromeDriver(options);
//       chromeDriver.get(url);
//       chromeDriver.findElement(By.id("forename")).sendKeys("Optimus Prime");
//       chromeDriver.findElement(By.id("submit")).click();
//   }

//    @Test
//    public void chromeLoginBtnClickedTest(){
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--allow-all-origin=*");
//        WebDriver chromeDriver = new ChromeDriver(options);
//        chromeDriver.get(url);
//        chromeDriver.findElement(By.id("loginButton")).click();
//    }

//    @Test
//    public void chromeClickedDownUpLinksTest(){
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--allow-all-origin=*");
//        WebDriver chromeDriver = new ChromeDriver(options);
//        chromeDriver.get(url);
//        chromeDriver.findElement(By.className("anibtn")).click();
//        chromeDriver.findElement(By.className("transition-y")).click();
//    }

    @Test
    public void chromeClickedDownUpLinksTest(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--allow-all-origin=*");
        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.get(url);
        String text = chromeDriver.findElement(By.className("display-1")).getText();
        System.out.println(text);
    }

}
