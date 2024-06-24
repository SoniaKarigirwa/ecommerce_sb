package rw.ac.rca.online_shopping_system.services;

import rw.ac.rca.online_shopping_system.DTO.CartDTO;
import rw.ac.rca.online_shopping_system.DTO.CartItemDTO;
import rw.ac.rca.online_shopping_system.exceptions.ResourceNotFoundException;

public interface CartService {

    CartDTO getOrCreateCart();

    CartDTO addItemToCart(long cartId, CartItemDTO cartItemDTO) throws ResourceNotFoundException;
    CartDTO updateCart(long id, CartDTO cartDTO) throws ResourceNotFoundException;
    void deleteCart(long id) throws ResourceNotFoundException;
    void removeItemFromCart(long cartId,  long itemId) throws ResourceNotFoundException;
}
