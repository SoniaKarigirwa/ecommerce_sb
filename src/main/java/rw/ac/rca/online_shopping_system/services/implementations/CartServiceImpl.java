package rw.ac.rca.online_shopping_system.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import rw.ac.rca.online_shopping_system.DTO.CartDTO;
import rw.ac.rca.online_shopping_system.DTO.CartItemDTO;
import rw.ac.rca.online_shopping_system.exceptions.ResourceNotFoundException;
import rw.ac.rca.online_shopping_system.models.Cart;
import rw.ac.rca.online_shopping_system.models.CartItem;
import rw.ac.rca.online_shopping_system.models.User;
import rw.ac.rca.online_shopping_system.repositories.CartItemRepository;
import rw.ac.rca.online_shopping_system.repositories.CartRepository;
import rw.ac.rca.online_shopping_system.repositories.UserRepository;
import rw.ac.rca.online_shopping_system.services.CartService;

import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, UserRepository userRepository, CartItemRepository cartItemRepository){
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.cartItemRepository = cartItemRepository;
    }


    @Override
    public CartDTO getOrCreateCart(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        User user = userRepository.findByEmail(currentPrincipalName)
        .orElseThrow(() -> new ResourceNotFoundException("User", "email", currentPrincipalName));

        Cart cart = cartRepository.findByUser(user).orElseGet(() -> {
            Cart newCart = new Cart(user);
            return cartRepository.save(newCart);
        });

        return new CartDTO(cart.getCartItems().stream().map(this::convertToCartItemDTO).collect(Collectors.toList()));
    }

    @Override
    public CartDTO addItemToCart(long cartId, CartItemDTO cartItemDTO) throws ResourceNotFoundException {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new ResourceNotFoundException("Cart", "id", String.valueOf(cartId)));
        CartItem cartItem = cartItemDTO.toEntity();
        cartItem.setCart(cart);
        cart.getCartItems().add(cartItem);
        cartRepository.save(cart);
        return new CartDTO(cart.getCartItems().stream().map(this::convertToCartItemDTO).collect(Collectors.toList()));
    }

    @Override
    public CartDTO updateCart(long id, CartDTO cartDTO) throws ResourceNotFoundException {
        Cart cart = cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart", "id", String.valueOf(id)));
        cart.setCartItems(cartDTO.getCartItems().stream().map(CartItemDTO::toEntity).collect(Collectors.toList()));
        cartRepository.save(cart);
        return new CartDTO(cart.getCartItems().stream().map(this::convertToCartItemDTO).collect(Collectors.toList()));
    }

    @Override
    public void deleteCart(long id) throws ResourceNotFoundException {
        Cart cart = cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart", "id", String.valueOf(id)));
        cartRepository.delete(cart);
    }

    @Override
    public void removeItemFromCart(long cartId, long itemId) throws ResourceNotFoundException {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new ResourceNotFoundException("Cart", "id", String.valueOf(cartId)));
        CartItem cartItem = cartItemRepository.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("CartItem", "id", String.valueOf(itemId)));
        cart.getCartItems().remove(cartItem);
        cartItemRepository.delete(cartItem);
    }

    private CartItemDTO convertToCartItemDTO(CartItem cartItem) {
        return new CartItemDTO(cartItem.getProductCode(), cartItem.getName(), cartItem.getDescription(), cartItem.getPrice(), cartItem.getQuantity(), cartItem.getImageUrl());
    }

}
