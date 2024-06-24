package rw.ac.rca.online_shopping_system.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.ac.rca.online_shopping_system.DTO.QuantityDTO;
import rw.ac.rca.online_shopping_system.exceptions.ResourceNotFoundException;
import rw.ac.rca.online_shopping_system.models.Quantity;
import rw.ac.rca.online_shopping_system.repositories.QuantityRepository;
import rw.ac.rca.online_shopping_system.services.QuantityService;

import java.util.List;

@Service
public class QuantityServiceImpl implements QuantityService {

    private final QuantityRepository quantityRepository;

    @Autowired
    public QuantityServiceImpl(QuantityRepository quantityRepository) {
        this.quantityRepository = quantityRepository;
    }

    @Override
    public Quantity addQuantity(QuantityDTO quantityDTO) {
        Quantity quantity = quantityDTO.toEntity();
        return quantityRepository.save(quantity);
    }

    @Override
    public List<Quantity> getAllQuantities() {
        return quantityRepository.findAll();
    }

    @Override
    public Quantity getQuantityById(Long id) throws ResourceNotFoundException {
        return quantityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quantity", "id", String.valueOf(id)));
    }

    @Override
    public Quantity updateQuantity(Long id, QuantityDTO quantityDetails) throws ResourceNotFoundException {
        Quantity quantity = quantityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quantity", "id", String.valueOf(id)));
        quantity.setProductCode(quantityDetails.getProductCode());
        quantity.setQuantity(quantityDetails.getQuantity());
        quantity.setOperation(quantityDetails.getOperation());
        quantity.setDate(quantityDetails.getDate());
        return quantityRepository.save(quantity);
    }

    @Override
    public void deleteQuantity(Long id) throws ResourceNotFoundException {
        Quantity quantity = quantityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quantity", "id", String.valueOf(id)));
        quantityRepository.delete(quantity);
    }
}