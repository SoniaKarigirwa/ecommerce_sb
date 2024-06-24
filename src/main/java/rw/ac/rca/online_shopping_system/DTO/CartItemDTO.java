package rw.ac.rca.online_shopping_system.DTO;


import lombok.Getter;
import lombok.Setter;
import rw.ac.rca.online_shopping_system.models.CartItem;

@Getter
@Setter
public class CartItemDTO {
    private String productCode;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String imageUrl;

    public CartItemDTO(String productCode, String name, String description, double price, int quantity, String imageUrl) {
        this.productCode = productCode;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
    }

    public CartItem toEntity() {
        CartItem cartItem = new CartItem();
        cartItem.setProductCode(this.productCode);
        cartItem.setName(this.name);
        cartItem.setDescription(this.description);
        cartItem.setPrice(this.price);
        cartItem.setQuantity(this.quantity);
        cartItem.setImageUrl(this.imageUrl);
        return cartItem;
    }
}
