package rw.ac.rca.online_shopping_system.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import rw.ac.rca.online_shopping_system.models.Product;
import rw.ac.rca.online_shopping_system.services.ProductService;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
}
