package rw.ac.rca.online_shopping_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.rca.online_shopping_system.models.Cart;
import rw.ac.rca.online_shopping_system.models.User;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long>{
    Optional<Cart> findByUser(User user);
}
