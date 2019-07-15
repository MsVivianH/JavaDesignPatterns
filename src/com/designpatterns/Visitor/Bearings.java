package com.designpatterns.Visitor;


public class Bearings implements VisitableInterface {
    @Override
    public void acceptVisitor(WheelVisitorInterface visitor) {
        visitor.visit(this);
    }
}
