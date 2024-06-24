package rw.ac.rca.online_shopping_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.rca.online_shopping_system.models.Purchased;
import rw.ac.rca.online_shopping_system.models.User;

import java.util.List;

public interface PurchasedRepository extends JpaRepository<Purchased, Long> {
    List<Purchased> findByUser(User user);
}
