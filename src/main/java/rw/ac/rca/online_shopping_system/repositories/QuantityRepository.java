package rw.ac.rca.online_shopping_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.rca.online_shopping_system.models.Quantity;

public interface QuantityRepository extends JpaRepository<Quantity, Long>{
}
