package com.accesshq.playground.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Form {
    WebDriver driver;

    public Form(WebDriver driver){
        this.driver = driver;
    }

    public void enterName(String name){
        WebElement nameInputElm = driver.findElement(By.id("name"));
        nameInputElm.sendKeys(name);
    }

    public void enterEmail(String email){
        WebElement emailInputElm = driver.findElement(By.id("email"));
        emailInputElm.sendKeys(email);
    }

    public void selectState(String state){

        driver.findElement(By.className("v-select__selections")).click();

        //wait for dropdown box to display
        WebDriverWait wait = new WebDriverWait(driver,10);
        By optionBox = By.cssSelector("[role=option]");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(optionBox));

        var options = driver.findElements(optionBox);
        for(var option:options){
            if(option.getText().equalsIgnoreCase(state)){
                option.click();
                return;
            }
        }
    }

    public void clickAgree(){
        WebElement checkedElm = driver.findElement(By.id("agree"));
        Actions at = new Actions(driver);
        at.moveToElement(checkedElm).click().perform();
    }

    public void submit(){
        var allBtn = driver.findElements(By.tagName("button"));
        for(var btn:allBtn){
            if(btn.getText().equalsIgnoreCase("submit")){
                btn.click();
            }
        }

    }
}
