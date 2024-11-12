package org.rahulshettyacademy.designpattern.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.designpattern.AbstractComponents.SearchFlightAvail;
import org.rahulshettyacademy.designpattern.AbstractComponents.StrategyFactor;
import org.rahulshettyacademy.designpattern.PageComponent.FooterNav;
import org.rahulshettyacademy.designpattern.PageComponent.NavigationBar;
import java.time.Duration;
import java.util.HashMap;

public class TravelHomePage {
    WebDriver driver;
    String url="https://rahulshettyacademy.com/dropdownsPractise/";
    By sectionElement=By.id("traveller-home");
    By headerSectionElement=By.id("buttons");
    SearchFlightAvail searchFlightAvail;

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void goTo(){
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
    }

    public NavigationBar getNavigationBar(){
        return new NavigationBar(driver,headerSectionElement);
    }

    public FooterNav getFooterNav(){
        return new FooterNav(driver,sectionElement);
    }

    public void setBookingStrategy(String strategyType){
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        searchFlightAvail=strategyFactor.createStrategy(strategyType);
        this.searchFlightAvail=searchFlightAvail;
    }

    public void checkAvail(HashMap<String,String>reservationDetails) throws InterruptedException {
        searchFlightAvail.checkAvail(reservationDetails);
    }

    public String getTitle(){
        return driver.getTitle();
    }
}