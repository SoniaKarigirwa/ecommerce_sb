package rw.ac.rca.online_shopping_system.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String productCode;
    String description;
    double price;
    int quantity;
    String imageUrl;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    Cart cart;
}
