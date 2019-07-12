package com.designpatterns.Observor2;

import com.designpatterns.Observer.Speedometer;

public interface SpeedometerListener {
    void speedChange(SpeedometerEvent event);
}
