package rw.ac.rca.online_shopping_system.DTO;


import lombok.Data;
import rw.ac.rca.online_shopping_system.models.Product;

@Data
public class ProductDTO {
    private String code;
    private String name;
    private double price;
    private String inDate;
    private String image;

    public Product toEntity() {
        Product product = new Product();
        product.setCode(this.code);
        product.setName(this.name);
        product.setPrice(this.price);
        product.setInDate(this.inDate);
        product.setImage(this.image);
        return product;
    }
}
