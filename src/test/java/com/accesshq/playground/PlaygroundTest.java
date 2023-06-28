package com.accesshq.playground;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaygroundTest {
    private final String baseUrl = "https://d18u5zoaatmpxx.cloudfront.net/#/";
    private final String formUrl = "https://d18u5zoaatmpxx.cloudfront.net/#/forms";
    private WebDriver driver;

    @BeforeEach
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--allow-all-origin=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void homepageHeroTextTest(){
        driver.get(baseUrl);
        String heroText = driver.findElement(By.className("display-1")).getText();
        Assertions.assertEquals("Web Playground",heroText);
    }


    @Test
    public void clickMeDownChangeTextTest(){
        driver.get(baseUrl);
        String expectedText = "CLICK ME UP!";
        var aniBtn = driver.findElement(By.cssSelector("a.anibtn"));
        aniBtn.click();
        //wait for text change
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.textToBePresentInElement(aniBtn,"CLICK ME UP!"));
        String actualTextAfterClicked = aniBtn.getText();
        Assertions.assertEquals(expectedText,actualTextAfterClicked);
    }


    @Test
    public void clickMeUpChangeTextTest(){
        //Setup
        driver.get(baseUrl);
        String expectedText = "CLICK ME DOWN!";
        var aniBtn = driver.findElement(By.cssSelector("a.anibtn"));

        //Action
        aniBtn.click();

        //wait for text change
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.textToBePresentInElement(aniBtn,"CLICK ME DOWN!"));
        String actualTextAfterClicked = aniBtn.getText();

        //Assert
        Assertions.assertEquals(expectedText,actualTextAfterClicked);

    }

    @Test
    public void submitFormTest(){
        //setup


        //Action
        driver.get(formUrl);
        WebElement btnModernTab = driver.findElement(By.className("v-tab"));
        btnModernTab.click();

        WebElement nameInputElm = driver.findElement(By.id("name"));
        nameInputElm.sendKeys("Phary");

        WebElement emailInputElm = driver.findElement(By.id("email"));
        emailInputElm.sendKeys("example@gmail.com");

        WebElement stateInputElm = driver.findElement(By.id("state"));
        stateInputElm.sendKeys("NSW");

//        driver.findElement(By.id("state")).click();
//        var options = driver.findElements(By.cssSelector("[role=option]"));

        WebElement checkedElm = driver.findElement(By.id("agree"));
        Actions at = new Actions(driver);
        at.moveToElement(checkedElm).click().perform();

        //click submit button
        var allBtn = driver.findElements(By.tagName("button"));
        System.out.println("All Btn: " + allBtn);
        for(var btn:allBtn){
            if(btn.getText().equalsIgnoreCase("submit")){
                btn.click();
            }
        }

        WebDriverWait wait = new WebDriverWait(driver,5);
        By byPopupBox = By.cssSelector(".popup-message");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byPopupBox));
        String finalText = driver.findElement(byPopupBox).getText();

        //Assert
        Assertions.assertEquals("Thanks for your feedback Phary",finalText);
    }



//    @AfterEach
//    public void cleanup(){
//        driver.quit();
//    }

}
