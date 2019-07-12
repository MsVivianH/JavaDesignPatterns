package com.designpatterns.Behavioral;

import com.designpatterns.base.*;

import java.util.Arrays;
import java.util.Iterator;

public class MountainBikeRange implements Iterable<BikeInterface>{
    private BikeInterface[] bikes;

    public MountainBikeRange() {
        bikes = new BikeInterface[5];

        bikes[0] = new DownHill(new WideWheel(22));
        bikes[1] = new DownHill(new WideWheel(24));
        bikes[2] = new CrossCountry(new WideWheel(26));
        bikes[3] = new CrossCountry(new WideWheel(24));
        bikes[4] = new CrossCountry(new WideWheel(22));
    } //end constructor

    public BikeInterface[] getRange() {
        return bikes;
    } // end method

    @Override
    public Iterator<BikeInterface> iterator() {
        return Arrays.asList(bikes).iterator();
    }
} //end class
