package org.rahulshettyacademy.designpattern.PageComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.designpattern.AbstractComponents.AbstractComponent;
import org.rahulshettyacademy.designpattern.AbstractComponents.SearchFlightAvail;
import org.rahulshettyacademy.designpattern.AbstractComponents.StrategyFactor;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {
    private By multiCityRadioBtn=By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By popUp = By.id("MultiCityModelAlert");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By dest2=By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By searchBtn = By.id("ctl00_mainContent_btn_FindFlights");
    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }
    @Override
    public void checkAvail(HashMap<String, String> reservationDetails) throws InterruptedException {
        makeStateReady(s->selectOriginCity(reservationDetails.get("origin")));
        selectDestinationCity(reservationDetails.get("destination"));
        selectDestination2City(reservationDetails.get("destination2"));
        findElement(searchBtn).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer){
        System.out.println("I am inside MultiTrip class");
        findElement(multiCityRadioBtn).click();
        findElement(popUp).click();
        waitforElementToDisappear(popUp);
        consumer.accept(this);
        System.out.println("I am Done");
    }

    public void selectOriginCity(String origin){
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestinationCity(String destination){
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void selectDestination2City(String destination2){
        findElement(dest2).click();
        findElement(By.xpath("(//a[@value='"+destination2+"'])[3]")).click();
    }
}