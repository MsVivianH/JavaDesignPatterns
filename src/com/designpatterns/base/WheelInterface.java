package com.designpatterns.base;

import com.designpatterns.Visitor.VisitableInterface;

public interface WheelInterface extends VisitableInterface {
    int getSize();
    boolean isWide();

}
