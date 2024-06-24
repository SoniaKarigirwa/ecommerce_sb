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
public class Purchased {
    @Id
    @GeneratedValue
    long id;
    String productCode;
    int quantity;
    double total;
    String date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
}
