package rw.ac.rca.online_shopping_system.services.implementations;

import org.springframework.stereotype.Service;
import rw.ac.rca.online_shopping_system.exceptions.ResourceNotFoundException;
import rw.ac.rca.online_shopping_system.models.Cart;
import rw.ac.rca.online_shopping_system.models.CartItem;
import rw.ac.rca.online_shopping_system.models.Purchased;
import rw.ac.rca.online_shopping_system.models.User;
import rw.ac.rca.online_shopping_system.repositories.CartRepository;
import rw.ac.rca.online_shopping_system.repositories.PurchasedRepository;
import rw.ac.rca.online_shopping_system.services.CheckoutService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private final CartRepository cartRepository;
    private final PurchasedRepository purchasedRepository;

    public CheckoutServiceImpl(CartRepository cartRepository, PurchasedRepository purchasedRepository) {
        this.cartRepository = cartRepository;
        this.purchasedRepository = purchasedRepository;
    }

    @Override
    public void checkoutCart(long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart", "id", String.valueOf(cartId)));
        User user = cart.getUser();

        List<Purchased> purchasedItems = cart.getCartItems().stream()
                .map(cartItem -> convertToPurchased(cartItem, user))
                .collect(Collectors.toList());
        purchasedRepository.saveAll(purchasedItems);

        cart.getCartItems().clear();
        cartRepository.save(cart);
    }
    private Purchased convertToPurchased(CartItem cartItem, User user) {
        Purchased purchased = new Purchased();
        purchased.setProductCode(cartItem.getProductCode());
        purchased.setQuantity(cartItem.getQuantity());
        purchased.setTotal(cartItem.getPrice() * cartItem.getQuantity());
        purchased.setDate(new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
        purchased.setUser(user);
        return purchased;
    }
}
