package ru.mirea.fourthteen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BuildingController {

    private List<Building> buildingList = new ArrayList<>();

    @GetMapping("/buildings")
    public String getAllBuildings(Model model) {
        model.addAttribute("buildings", buildingList);
        return "building-list";
    }

    @PostMapping("/buildings")
    public String createBuilding(@ModelAttribute Building building) {
        buildingList.add(building);
        return "redirect:/buildings";
    }

    @DeleteMapping("/buildings/{id}")
    public String deleteBuilding(@PathVariable int id) {
        buildingList.remove(id);
        return "redirect:/buildings";
    }
}
