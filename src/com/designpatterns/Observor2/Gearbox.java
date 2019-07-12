package com.designpatterns.Observor2;

public class Gearbox implements SpeedometerListener {

    @Override
    public void speedChange(SpeedometerEvent event) {
        if (event.getSpeed() <= 5) {
            System.out.println("Now in easy gear");
        } else if (event.getSpeed() <= 10) {
            System.out.println("Now in 2nd gear");
        } else if (event.getSpeed() <= 20) {
            System.out.println("Now in 3rd gear");
        } else if (event.getSpeed() <= 25) {
            System.out.println("Now in 4thd gear");
        } else if (event.getSpeed() <= 30) {
            System.out.println("Now in 5th gear");

        } // end constructor

    } // end method

} // end class
