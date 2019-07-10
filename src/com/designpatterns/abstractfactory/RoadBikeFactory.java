package com.designpatterns.abstractfactory;

public class RoadBikeFactory extends AbstractBikeFactory {

    @Override
    public BikeFrameInterface createFrame() {
        return new RoadFrame();
    }

    @Override
    public BikeSeatInterface createseat() {
        return new RoadSeat();
    }
}
