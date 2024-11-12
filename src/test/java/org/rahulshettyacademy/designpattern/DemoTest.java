package org.rahulshettyacademy.designpattern;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.rahulshettyacademy.designpattern.PageObjects.TravelHomePage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class DemoTest extends BaseTest {
    WebDriver driver;
    TravelHomePage travelHomePage;
    @BeforeTest
    public void setUp(){
        driver = initializeDriver();
        travelHomePage = new TravelHomePage(driver);
        travelHomePage.goTo();
    }

    @Test
    public void simpleflightTest(){
        //FooterNav
        System.out.println(travelHomePage.getFooterNav().getFlightAttribute());
        System.out.println(travelHomePage.getFooterNav().getLinkCounts());

        //NavigationBar
        System.out.println(travelHomePage.getNavigationBar().getFlightAttribute());
        System.out.println(travelHomePage.getNavigationBar().getLinksCount());
    }

    @Test (dataProvider = "getData")
    public void flightTest(HashMap<String,String>reservationDetails) throws InterruptedException {
        travelHomePage.setBookingStrategy("multitrip");
        travelHomePage.checkAvail(reservationDetails);
    }

    @DataProvider
    public Object [][] getData () throws IOException {
        List<HashMap<String,String>>list=getJSONData(System.getProperty("user.dir")+"//src//main//java//org//rahulshettyacademy//designpattern//DataLodes//reservationDetails.json");
        return new Object[][]{
                {list.get(0)},{list.get(1)}
        };
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}