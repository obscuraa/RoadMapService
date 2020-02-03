package com.company;

public class Main {
    public static void main(String[] args) {
        CityHandler cityHandler = new CityHandler();

        cityHandler.addCity(new City("Moscow", 0, 5)); //1.	Добавление нового города
        cityHandler.addCity(new City("Vologda", 1, 4));
        cityHandler.addCity(new City("Ufa", 3, 2));

        cityHandler.findCityByName("Moscow").createRoad("From Moscow to Vologda", 3.0); //2.	Добавление новой дороги
        cityHandler.findCityByName("Vologda").createRoad("From Vologda to Moscow", 3.0);
        cityHandler.findCityByName("Ufa").createRoad("From Ufa to Moscow", 4.0);
        cityHandler.findCityByName("Moscow").createRoad("From Moscow to Ufa", 1.0);

        System.out.println("Cities: " + cityHandler.getCities());
        System.out.println("Moscow's roads are: " + cityHandler.findRoadsByCityName("Moscow"));

        System.out.println("Removing Moscow road to Ufa...");
        cityHandler.findCityByName("Moscow").deleteRoadByName("From Moscow to Ufa"); //3.	Удаление дороги
        System.out.println("Moscow's roads are: " + cityHandler.findCityByName("Moscow").getRoads()); //4.	Получение города по имени
    }
}
