package org.rahulshettyacademy.designpattern.PageComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.designpattern.AbstractComponents.AbstractComponent;

public class NavigationBar extends AbstractComponent {
    By flights=By.cssSelector("[title='Flights']");
    By links=By.cssSelector("a");
    public NavigationBar(WebDriver driver, By headerSectionElement) {
        super(driver, headerSectionElement);
    }
    public String getFlightAttribute(){
        return findElement(flights).getAttribute("class");
    }

    public int getLinksCount(){
        return findElements(links).size();
    }
}