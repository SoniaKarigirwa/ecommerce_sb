package rw.ac.rca.online_shopping_system.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import rw.ac.rca.online_shopping_system.models.Purchased;
import rw.ac.rca.online_shopping_system.services.PurchasedService;
import rw.ac.rca.online_shopping_system.services.UserService;

@RestController
public class PurchasedController {
    private final PurchasedService purchasedService;
    private final UserService userService;

    @Autowired
    public PurchasedController(PurchasedService purchasedService, UserService userService) {
        this.purchasedService = purchasedService;
        this.userService = userService;
    }
}
