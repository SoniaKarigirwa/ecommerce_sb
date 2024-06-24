package rw.ac.rca.online_shopping_system.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import rw.ac.rca.online_shopping_system.models.Quantity;

@Data
@AllArgsConstructor
public class QuantityDTO {
    private String productCode;
    private int quantity;
    private String operation;
    private String date;

    public Quantity toEntity() {
        Quantity quantity = new Quantity();
        quantity.setProductCode(this.productCode);
        quantity.setQuantity(this.quantity);
        quantity.setOperation(this.operation);
        quantity.setDate(this.date);
        return quantity;
    }
}
