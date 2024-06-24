package rw.ac.rca.online_shopping_system.controllers;


import org.springframework.web.bind.annotation.RestController;
import rw.ac.rca.online_shopping_system.models.Quantity;
import rw.ac.rca.online_shopping_system.services.QuantityService;

@RestController
public class QuantityController {
    private final QuantityService quantityService;

    public QuantityController(QuantityService quantityService) {
        this.quantityService = quantityService;
    }
}
