package com.company;

public class Road {
    private final String roadName;
    private double roadLength;

    public Road(String roadName, double roadLength) {
        this.roadName = roadName;
        this.roadLength = roadLength;
    }

    public String getRoadName() {
        return roadName;
    }

    @Override
    public String toString() {
        return roadName + " " + roadLength;
    }
}
