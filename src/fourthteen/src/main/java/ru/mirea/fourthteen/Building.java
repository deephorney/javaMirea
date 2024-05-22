package ru.mirea.fourthteen;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Building {
    private String creationDate;
    private String type;

    public Building(String creationDate, String type) {
        this.creationDate = creationDate;
        this.type = type;
    }
}
