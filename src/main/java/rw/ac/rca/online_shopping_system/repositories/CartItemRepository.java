package rw.ac.rca.online_shopping_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.rca.online_shopping_system.models.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
