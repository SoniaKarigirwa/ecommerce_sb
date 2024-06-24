package rw.ac.rca.online_shopping_system.DTO;


import lombok.Data;
import rw.ac.rca.online_shopping_system.models.User;
import rw.ac.rca.online_shopping_system.utils.EnumConverter;

@Data
public class UserDTO {
    private String firstname;
    private String email;
    private String password;
    private String phone;
    private String role;

    public User toEntity() {
        User user = new User();
        user.setFirstname(this.firstname);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setPhone(this.phone);
        user.setRole(EnumConverter.getUserRole(role));
        return user;
    }
}
