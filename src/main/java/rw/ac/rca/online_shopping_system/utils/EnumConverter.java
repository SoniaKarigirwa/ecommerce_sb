package rw.ac.rca.online_shopping_system.utils;

import rw.ac.rca.online_shopping_system.enums.UserRole;

public class EnumConverter {
    public static UserRole getUserRole(String role) {
        try {
            return UserRole.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid role: " + role);
        }
    }
}
