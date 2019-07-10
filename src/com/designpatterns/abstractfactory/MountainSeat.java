package com.designpatterns.abstractfactory;

public class MountainSeat implements BikeSeatInterface {
    @Override
    public String getSeatPart() {
        return "Seat parts for the Mountain Bike.";
    }
}
