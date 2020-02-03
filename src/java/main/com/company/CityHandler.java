package com.company;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CityHandler {
    private List<City> cities = new CopyOnWriteArrayList<>();

    public List<City> getCities() {
        return cities;
    }

    public City findCityByName(String name) {
        return cities.stream()
                .filter(city -> city.getCityName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NullPointerException("There is no city with that name"));
    }

    public void addCity(City city) {
        if (isExist(city.getCityName(), city.getxCityCoordinate(), city.getyCityCoordinate())) {
            throw new IllegalArgumentException("City already exists");
        }
        City addedCity = new City(city.getCityName(), city.getxCityCoordinate(), city.getyCityCoordinate());
        cities.add(addedCity);
    }

    public List<Road> findRoadsByCityName(String name) {
        City city = cities.stream()
                .filter(c -> c.getCityName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NullPointerException("There is no city with that name"));
        return city.getRoads();
    }

    private boolean isExist(String name, int xCityCoordinate, int yCityCoordinate) {
        for (City city : cities) {
            if (city.getCityName().equals(name)) {
                return true;
            }
            if (city.getyCityCoordinate() == yCityCoordinate && city.getxCityCoordinate() == xCityCoordinate) {
                return true;
            }
        }
        return false;
    }
}
