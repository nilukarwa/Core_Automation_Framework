package org.rahulshettyacademy.designpattern.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AbstractComponent {
    WebElement sectionElement;
    WebDriver driver;
    public AbstractComponent(WebDriver driver, By sectionElement) {
        this.driver=driver;
        this.sectionElement=driver.findElement(sectionElement);
    }

    public WebElement findElement(By findElementBy){
        return sectionElement.findElement(findElementBy);
    }
    public List<WebElement> findElements(By findElementBy){
        return sectionElement.findElements(findElementBy);
    }

    public void waitforElementToDisappear(By findBy){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }
}