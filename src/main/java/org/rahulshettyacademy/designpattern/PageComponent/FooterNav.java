package org.rahulshettyacademy.designpattern.PageComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.designpattern.AbstractComponents.AbstractComponent;
public class FooterNav extends AbstractComponent {
    By flights=By.cssSelector("[title='Flights']");
    By links=By.cssSelector("a");

    public FooterNav(WebDriver driver, By sectionElement) {
        super(driver,sectionElement);
    }

    public String getFlightAttribute(){
        return findElement(flights).getAttribute("class");
    }

    public int getLinkCounts(){
        return findElements(links).size();
    }
}