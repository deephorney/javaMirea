package ru.mirea.fourthteen;

import java.util.ArrayList;
import java.util.List;

public class AddressController {
    private List<Address> addresses;

    public AddressController() {
        this.addresses = new ArrayList<>();
    }

    public void createAddress(String addressText, String zipCode) {
        Address address = new Address(addressText, zipCode);
        addresses.add(address);
    }

    public void deleteAddress(Address address) {
        addresses.remove(address);
    }

    public List<Address> getAllAddresses() {
        return addresses;
    }
}
