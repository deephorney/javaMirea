package ru.mirea.fourthteen;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String addressText;
    private String zipCode;

    public Address(String addressText, String zipCode) {
        this.addressText = addressText;
        this.zipCode = zipCode;
    }
}
