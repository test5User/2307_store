package by.itclass.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Laptop {
    private int id;
    private String vendor;
    private String model;
    private String cpu;
    private int memorySize;
    private double price;
}
