package by.itclass.model.entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class OrderItem {
    private String orderId;
    private final int itemType;
    private final int itemId;
    private final String itemVendor;
    private final String itemModel;
    private final Double itemPrice;
    @NonNull @Setter
    private int quantity;
}
