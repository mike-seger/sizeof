package com.net128.jvm.util.sizeof;

import org.openjdk.jol.info.GraphLayout;

public class InstrumentationExample {
    public static void main(String[] arguments) {
        var floats = new Floats(1000, 12);
        var doubles = new Doubles(1000, 12);
        var twelveAttrObjects = new TwelveFloatAttrObjects(1000);
        System.out.println("floats size: " + GraphLayout.parseInstance(floats).totalSize());
        System.out.println("doubles size: " + GraphLayout.parseInstance(doubles).totalSize());
        System.out.println("twelveAttrObjects size: " + GraphLayout.parseInstance(twelveAttrObjects).totalSize());
    }
}