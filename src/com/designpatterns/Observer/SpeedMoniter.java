package com.designpatterns.Observer;

import java.util.Observable;
import java.util.Observer;

public class SpeedMoniter implements Observer {
    public static final int SPEED_TO_ALERT = 30;

    @Override
    public void update(Observable obs, Object arg) {
        Speedometer speedo = (Speedometer) obs;
        if (speedo.getCurrentSpeed() >= SPEED_TO_ALERT) {
            System.out.println("** Alert ** Moving too fast! ("
             + speedo.getCurrentSpeed() + ")");
        } else {
            System.out.println("... nice and steady ...("
             + speedo.getCurrentSpeed() + ")");
        }
    }
}
