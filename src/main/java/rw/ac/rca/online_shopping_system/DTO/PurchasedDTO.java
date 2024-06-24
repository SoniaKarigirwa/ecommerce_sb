package rw.ac.rca.online_shopping_system.DTO;


import lombok.Data;
import rw.ac.rca.online_shopping_system.models.Purchased;

@Data
public class PurchasedDTO {
    private String productCode;
    private int quantity;
    private double total;
    private String date;

    public Purchased toEntity() {
        Purchased purchased = new Purchased();
        purchased.setProductCode(this.productCode);
        purchased.setQuantity(this.quantity);
        purchased.setTotal(this.total);
        purchased.setDate(this.date);
        return purchased;
    }
}
