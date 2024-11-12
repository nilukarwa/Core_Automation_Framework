package org.rahulshettyacademy.designpattern.AbstractComponents;

import org.openqa.selenium.By;

import java.util.HashMap;

public interface SearchFlightAvail {
    void checkAvail(HashMap<String,String> reservationDetails) throws InterruptedException;
}