package com.designpatterns.abstractfactory;

public class RoadSeat implements BikeSeatInterface {
    @Override
    public String getSeatPart() {
        return "Seat parts for the Road Bike.";
    }
}
