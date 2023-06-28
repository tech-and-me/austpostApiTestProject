package com.accesshq.playground;


import com.accesshq.playground.model.Form;
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

public class PlaygroundTest2 {
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
    public void submitFormTest(){
        //setup

        //Action
        driver.get(formUrl);
        WebElement btnModernTab = driver.findElement(By.className("v-tab"));
        btnModernTab.click();

        Form form = new Form(driver);
        String name = "Phary";
        form.enterName(name);
        form.enterEmail("example@gmail.com");
        form.selectState("NSW");
        form.clickAgree();
        form.submit();

        WebDriverWait wait = new WebDriverWait(driver,10);
        By byPopupBox = By.cssSelector(".popup-message");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byPopupBox));
        String finalText = driver.findElement(byPopupBox).getText();

        //Assert
        String thankYouText = "Thanks for your feedback" + " " + name;
        Assertions.assertEquals(thankYouText,finalText);
    }

    @Test
    public void clickPlanetEarthTest(){
        driver.get(baseUrl);
        WebElement planetsTab = driver.findElement(By.cssSelector("[aria-label = planets]"));
        planetsTab.click();

        //Select all planets elements
        var allPlanetCards = driver.findElements(By.cssSelector(".planet"));

        //find planet earth
        for(var planet:allPlanetCards){
            if(planet.findElement(By.tagName("h2")).getText().equalsIgnoreCase("earth")){
                planet.findElement(By.tagName("button")).click();
                //select pop
                WebDriverWait wait = new WebDriverWait(driver,10);
                By byPopupBox = By.cssSelector(".sna");
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byPopupBox));
            }
        }

    }


//    @AfterEach
//    public void cleanup(){
//        driver.quit();
//    }

}
