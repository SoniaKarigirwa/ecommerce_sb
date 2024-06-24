package rw.ac.rca.online_shopping_system.services;

import rw.ac.rca.online_shopping_system.DTO.UserDTO;
import rw.ac.rca.online_shopping_system.models.User;

public interface UserService {
    User registerUser(UserDTO userDTO);
    User findByEmail(String email);
    boolean authenticate(String email, String password);
}
