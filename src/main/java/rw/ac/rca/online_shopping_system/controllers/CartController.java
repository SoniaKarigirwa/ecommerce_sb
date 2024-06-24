package rw.ac.rca.online_shopping_system.controllers;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rw.ac.rca.online_shopping_system.DTO.CartDTO;
import rw.ac.rca.online_shopping_system.DTO.CartItemDTO;
import rw.ac.rca.online_shopping_system.DTO.Response;
import rw.ac.rca.online_shopping_system.enums.ResponseType;
import rw.ac.rca.online_shopping_system.services.CartService;
import rw.ac.rca.online_shopping_system.services.CheckoutService;
import rw.ac.rca.online_shopping_system.utils.ExceptionHandlerUtil;

@RestController
public class CartController {
    private final CartService cartService;
    private final CheckoutService checkoutService;

    @Autowired
    public CartController(CartService cartService, CheckoutService checkoutService) {
        this.cartService = cartService;
        this.checkoutService = checkoutService;
    }
    @GetMapping
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "User: Get or Create Cart")
    public ResponseEntity<Response> getOrCreateCart() {
        try {
            return ResponseEntity.status(200).body(new Response().setResponseType(ResponseType.SUCCESS).setPayload(cartService.getOrCreateCart()));
        } catch (Exception e) {
            return ExceptionHandlerUtil.handleException(e);
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "User: Update a Cart by ID")
    public ResponseEntity<Response> updateCart(@PathVariable long id, @RequestBody CartDTO cartDTO) {
        try {
            return ResponseEntity.status(200).body(new Response().setResponseType(ResponseType.SUCCESS).setPayload(cartService.updateCart(id, cartDTO)));
        } catch (Exception e) {
            return ExceptionHandlerUtil.handleException(e);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "User: Delete a Cart by ID")
    public ResponseEntity<Response> deleteCart(@PathVariable long id) {
        try {
            cartService.deleteCart(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ExceptionHandlerUtil.handleException(e);
        }
    }

    @PostMapping("/{cartId}/items")
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "User: Add an Item to a Cart")
    public ResponseEntity<Response> addItemToCart(@PathVariable long cartId, @RequestBody CartItemDTO cartItemDTO) {
        try {
            return ResponseEntity.status(201).body(new Response().setResponseType(ResponseType.SUCCESS).setPayload(cartService.addItemToCart(cartId, cartItemDTO)));
        } catch (Exception e) {
            return ExceptionHandlerUtil.handleException(e);
        }
    }

    @DeleteMapping("/{cartId}/items/{itemId}")
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "User: Remove an Item from a Cart")
    public ResponseEntity<Response> removeItemFromCart(@PathVariable long cartId, @PathVariable long itemId) {
        try {
            cartService.removeItemFromCart(cartId, itemId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ExceptionHandlerUtil.handleException(e);
        }
    }

    @PostMapping("/{cartId}/checkout")
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "User: Checkout a Cart")
    public ResponseEntity<Response> checkoutCart(@PathVariable long cartId) {
        try {
            checkoutService.checkoutCart(cartId);
            return ResponseEntity.status(200).body(new Response().setResponseType(ResponseType.SUCCESS).setMessage("Checkout successful"));
        } catch (Exception e) {
            return ExceptionHandlerUtil.handleException(e);
        }
    }
}
