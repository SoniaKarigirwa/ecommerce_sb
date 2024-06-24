package rw.ac.rca.online_shopping_system.services;

import rw.ac.rca.online_shopping_system.DTO.QuantityDTO;
import rw.ac.rca.online_shopping_system.exceptions.ResourceNotFoundException;
import rw.ac.rca.online_shopping_system.models.Quantity;

import java.util.List;

public interface QuantityService {
    Quantity addQuantity(QuantityDTO quantityDTO);
    List<Quantity> getAllQuantities();
    Quantity getQuantityById(Long id) throws ResourceNotFoundException;
    Quantity updateQuantity(Long id, QuantityDTO quantityDetails) throws ResourceNotFoundException;
    void deleteQuantity(Long id) throws ResourceNotFoundException;
}
