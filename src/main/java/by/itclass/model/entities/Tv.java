package by.itclass.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Tv {
    private int id;
    private String vendor;
    private String model;
    private int screenSize;
    private double price;
}
