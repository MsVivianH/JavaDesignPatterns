package com.designpatterns.java;

import com.designpatterns.Behavioral.MountainBikeRange;
import com.designpatterns.Behavioral.RoadBikeRange;
import com.designpatterns.Builder.BikeBuilder;
import com.designpatterns.Builder.BikeDirector;
import com.designpatterns.Builder.RoadBikeBuilder;
import com.designpatterns.Builder.RoadBikeDirector;
import com.designpatterns.Observer.GearBox;
import com.designpatterns.Observer.SpeedMoniter;
import com.designpatterns.Observer.Speedometer;
import com.designpatterns.Observor2.SpeedMonitor;
import com.designpatterns.Singleton.SerialNumberGenerator;
import com.designpatterns.Visitor.WheelDiagnostics;
import com.designpatterns.Visitor.WheelInventory;
import com.designpatterns.abstractfactory.AbstractBikeFactory;
import com.designpatterns.abstractfactory.BikeFrameInterface;
import com.designpatterns.abstractfactory.BikeSeatInterface;
import com.designpatterns.abstractfactory.RoadBikeFactory;
import com.designpatterns.adapter.UltraWheel;
import com.designpatterns.adapter.UltraWheelAdapter;
import com.designpatterns.base.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        adapterExample();
        //visitorExample();
        //observerExample2();
        //observerExample1();
        //iteratorExample2();
        //iteratorExample1();
        //singletonExample();
        //builderExample();
        ///abstractFactoryExample();
    } // end Main Method

    private static void adapterExample(){
        UltraWheel ultraWheel = new UltraWheel(28);
        List<WheelInterface> wheels = new ArrayList<>();
        wheels.add(new NarrowWheel(24));
        wheels.add(new NarrowWheel(20));
        wheels.add(new WideWheel(24));
        wheels.add(new UltraWheelAdapter(ultraWheel));
        wheels.add(new UltraWheelAdapter(new UltraWheel(26)));

        for(WheelInterface wheel : wheels) {
            System.out.println(wheel);
        }
    } //end method


    private static void visitorExample() {
        WheelInterface wheel = new WideWheel(24);
        wheel.acceptVisitor(new WheelDiagnostics());
        wheel.acceptVisitor(new WheelInventory());
    }
    private static void observerExample2() {
        com.designpatterns.Observor2.Speedometer speed
                = new com.designpatterns.Observor2.Speedometer();
        speed.addSpeedometerListener(new com.designpatterns.Observor2.SpeedMonitor());
        speed.addSpeedometerListener(new com.designpatterns.Observor2.Gearbox());

        speed.setCurrentSpeed(5);
        speed.setCurrentSpeed(10);
        speed.setCurrentSpeed(20);
        speed.setCurrentSpeed(30);
        speed.setCurrentSpeed(35);
    }

    private static void observerExample1() {
        SpeedMoniter monitor = new SpeedMoniter();
        Speedometer speed = new Speedometer();
        speed.addObserver(monitor);
        speed.addObserver(new GearBox());

        speed.setCurrentSpeed(5);
        speed.setCurrentSpeed(10);
        speed.setCurrentSpeed(15);
        speed.setCurrentSpeed(20);
        speed.setCurrentSpeed(26);
        speed.setCurrentSpeed(33);
    }

    private static void iteratorExample2() {
        System.out.println("=== Our Mountain Bike");
        MountainBikeRange bikeRange = new MountainBikeRange();

        for (BikeInterface bike : bikeRange.getRange()) {
            System.out.println(bike);
        }
    }

    private static void iteratorExample1() {
        System.out.println("=== Our Road Bikes ===");
        RoadBikeRange bikeRange = new RoadBikeRange();
        printIterator(bikeRange.iterator());
    }

    private static void printIterator(Iterator iter) {
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    private static void singletonExample() {
        System.out.println("Generator Serial Number");
        SerialNumberGenerator generator = SerialNumberGenerator.getInstance();
        System.out.println("next serial = " + generator.getNextSerial());
        System.out.println("next serial = " + generator.getNextSerial());
        System.out.println("next serial = " + generator.getNextSerial());
        System.out.println("next serial = " + generator.getNextSerial());
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

