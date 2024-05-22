package ru.mirea.fourthteen;

import java.util.ArrayList;
import java.util.List;

public class BuildingController {
    private List<Building> buildings;

    public BuildingController() {
        this.buildings = new ArrayList<>();
    }

    public void createBuilding(String creationDate, String type) {
        Building building = new Building(creationDate, type);
        buildings.add(building);
    }

    public void deleteBuilding(Building building) {
        buildings.remove(building);
    }

    public List<Building> getAllBuildings() {
        return buildings;
    }
}
