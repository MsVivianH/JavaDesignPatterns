package com.designpatterns.java;

import com.designpatterns.Builder.BikeBuilder;
import com.designpatterns.Builder.BikeDirector;
import com.designpatterns.Builder.RoadBikeBuilder;
import com.designpatterns.Builder.RoadBikeDirector;
import com.designpatterns.Singleton.SerialNumberGenerator;
import com.designpatterns.abstractfactory.AbstractBikeFactory;
import com.designpatterns.abstractfactory.BikeFrameInterface;
import com.designpatterns.abstractfactory.BikeSeatInterface;
import com.designpatterns.abstractfactory.RoadBikeFactory;
import com.designpatterns.base.BikeInterface;
import com.designpatterns.base.NarrowWheel;
import com.designpatterns.base.RoadBike;
import com.designpatterns.base.Touring;

public class Main {

    public static void main(String[] args) {
       singletonExample();
        //builderExample();
       ///abstractFactoryExample();
    } // end Main Method

    private static void singletonExample() {
        System.out.println("Generator Serial Number");
        SerialNumberGenerator generator = SerialNumberGenerator.getInstance();
        System.out.println("next serial = "+generator.getNextSerial());
        System.out.println("next serial = "+generator.getNextSerial());
        System.out.println("next serial = "+generator.getNextSerial());
        System.out.println("next serial = "+generator.getNextSerial());
    }

    private static void builderExample() {
        RoadBike bike = new Touring(new NarrowWheel(22));
        BikeBuilder builder = new RoadBikeBuilder(bike);
        BikeDirector director = new RoadBikeDirector();
        BikeInterface bikeInterface = director.build(builder);
        System.out.println(bikeInterface);
    } // end method

    private static void abstractFactoryExample() {
        AbstractBikeFactory factory = new RoadBikeFactory();
        BikeFrameInterface frame = factory.createFrame();
        BikeSeatInterface seat = factory.createseat();

        System.out.println(frame.getFrameParts());
        System.out.println(seat.getSeatPart());
    } // end method

} // end class

