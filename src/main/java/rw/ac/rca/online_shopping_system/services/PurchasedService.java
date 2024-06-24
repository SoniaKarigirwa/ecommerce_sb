package rw.ac.rca.online_shopping_system.services;

import rw.ac.rca.online_shopping_system.DTO.PurchasedDTO;
import rw.ac.rca.online_shopping_system.models.Purchased;
import rw.ac.rca.online_shopping_system.models.User;

import java.util.List;

public interface PurchasedService {
    Purchased savePurchased(PurchasedDTO purchasedDTO);
    List<Purchased> getAllPurchased();
    List<Purchased> getPurchasedByUser(User user);
}
