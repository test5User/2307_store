package by.itclass.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ReceiptItem {
    private String itemInfo;
    private double itemPrice;
    private int quantity;
    private double itemAmount;
}
