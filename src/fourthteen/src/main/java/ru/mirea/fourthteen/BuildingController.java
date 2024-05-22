package ru.mirea.fourthteen;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BuildingController {

    private List<Building> buildingList = new ArrayList<>();

    @GetMapping("/buildings")
    @ResponseBody
    public String getAllBuildings() {
        return buildingList.toString();
    }

    @PostMapping("/buildings")
    @ResponseBody
    public String createBuilding(@RequestBody Building building) {
        buildingList.add(building);
        return "Building added: " + building.toString();
    }

    @DeleteMapping("/buildings/{id}")
    @ResponseBody
    public String deleteBuilding(@PathVariable int id) {
        if (id >= 0 && id < buildingList.size()) {
            buildingList.remove(id);
            return "Building deleted with id: " + id;
        } else {
            return "Building not found with id: " + id;
        }
    }
}
