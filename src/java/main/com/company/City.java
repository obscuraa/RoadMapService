package com.company;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class City {
    private final String cityName;
    private int xCityCoordinate;
    private int yCityCoordinate;
    private List<Road> roads = new CopyOnWriteArrayList<>();

    public City(String cityName, int xCityCoordinate, int yCityCoordinate) {
        this.cityName = cityName;
        this.xCityCoordinate = xCityCoordinate;
        this.yCityCoordinate = yCityCoordinate;
    }

    public List<Road> getRoads() {
        return roads;
    }

    public String getCityName() {
        return cityName;
    }

    public int getxCityCoordinate() {
        return xCityCoordinate;
    }

    public int getyCityCoordinate() {
        return yCityCoordinate;
    }

    public void createRoad(String roadName, double roadLength) {
        for (Road city : roads) {
            if (isRoadExist(roadName)) {
                throw new IllegalArgumentException("Road already exists");
            }
        }
        Road newRoad = new Road(roadName, roadLength);
        roads.add(newRoad);
    }

    public void deleteRoadByName(String roadName) {
        roads.removeIf(r -> r.getRoadName().equals(roadName));
    }

    public boolean isRoadExist(String name) {
        for (Road r : roads) {
            if (r.getRoadName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "cityName='" + cityName + ", x_scale=" + xCityCoordinate + ", y_scale=" + yCityCoordinate;
    }
}
