package rw.ac.rca.online_shopping_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.rca.online_shopping_system.models.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
   Optional<Product> findByCode(String code);
}
