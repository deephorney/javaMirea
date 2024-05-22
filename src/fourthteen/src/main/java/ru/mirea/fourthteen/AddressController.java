package ru.mirea.fourthteen;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AddressController {

    private List<Address> addressList = new ArrayList<>();

    @GetMapping("/addresses")
    @ResponseBody
    public String getAllAddresses() {
        return addressList.toString();
    }

    @PostMapping("/addresses")
    @ResponseBody
    public String createAddress(@RequestBody Address address) {
        addressList.add(address);
        return "Address added: " + address.toString();
    }

    @DeleteMapping("/addresses/{id}")
    @ResponseBody
    public String deleteAddress(@PathVariable int id) {
        if (id >= 0 && id < addressList.size()) {
            addressList.remove(id);
            return "Address deleted with id: " + id;
        } else {
            return "Address not found with id: " + id;
        }
    }
}
