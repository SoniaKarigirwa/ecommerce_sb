package rw.ac.rca.online_shopping_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.rca.online_shopping_system.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
