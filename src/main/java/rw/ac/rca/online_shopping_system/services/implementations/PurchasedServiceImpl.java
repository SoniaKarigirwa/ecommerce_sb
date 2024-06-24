package rw.ac.rca.online_shopping_system.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.ac.rca.online_shopping_system.DTO.PurchasedDTO;
import rw.ac.rca.online_shopping_system.models.Purchased;
import rw.ac.rca.online_shopping_system.models.User;
import rw.ac.rca.online_shopping_system.repositories.PurchasedRepository;
import rw.ac.rca.online_shopping_system.services.PurchasedService;

import java.util.List;

@Service
public class PurchasedServiceImpl implements PurchasedService {
    private final PurchasedRepository purchasedRepository;

    @Autowired
    public PurchasedServiceImpl(PurchasedRepository purchasedRepository) {
        this.purchasedRepository = purchasedRepository;
    }

    @Override
    public Purchased savePurchased(PurchasedDTO purchasedDTO) {
        Purchased purchased = purchasedDTO.toEntity();
        return purchasedRepository.save(purchased);
    }

    @Override
    public List<Purchased> getAllPurchased() {
        return purchasedRepository.findAll();
    }

    @Override
    public List<Purchased> getPurchasedByUser(User user){
        return purchasedRepository.findByUser(user);
    }

}
