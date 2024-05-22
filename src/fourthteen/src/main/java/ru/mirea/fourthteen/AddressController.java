package ru.mirea.fourthteen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AddressController {

    private List<Address> addressList = new ArrayList<>();

    @GetMapping("/addresses")
    public String getAllAddresses(Model model) {
        model.addAttribute("addresses", addressList);
        return "address-list";
    }

    @PostMapping("/addresses")
    public String createAddress(@ModelAttribute Address address) {
        addressList.add(address);
        return "redirect:/addresses";
    }

    @DeleteMapping("/addresses/{id}")
    public String deleteAddress(@PathVariable int id) {
        addressList.remove(id);
        return "redirect:/addresses";
    }
}
