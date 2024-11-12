package org.rahulshettyacademy.designpattern.PageComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.designpattern.AbstractComponents.AbstractComponent;
import org.rahulshettyacademy.designpattern.AbstractComponents.SearchFlightAvail;

import java.util.HashMap;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail {
    private By roundTripRadioBtn = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By indianArmedforceCheckBox=By.id("ctl00_mainContent_chk_IndArm");
    private By submit = By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By selectElement){
        super(driver,selectElement);
    }
    @Override
    public void checkAvail(HashMap<String,String>reservationDetails) {
        System.out.println("I am inside Round Trip");
        findElement(roundTripRadioBtn).click();
        selectOriginCity(reservationDetails.get("origin"));
        selectDestinationCity(reservationDetails.get("destination"));
        findElement(indianArmedforceCheckBox).click();
        findElement(submit).click();
    }

    public void selectOriginCity(String origin){
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestinationCity(String destination){
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }
}