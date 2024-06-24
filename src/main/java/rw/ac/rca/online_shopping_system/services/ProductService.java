package rw.ac.rca.online_shopping_system.services;

import rw.ac.rca.online_shopping_system.DTO.ProductDTO;
import rw.ac.rca.online_shopping_system.exceptions.ResourceNotFoundException;
import rw.ac.rca.online_shopping_system.models.Product;

public interface ProductService {
    Product addProduct(ProductDTO productDTO);
    Iterable<Product> getAllProducts();
    Product getProductById(Long id) throws ResourceNotFoundException;
    Product updateProduct(Long id, ProductDTO productDetails) throws ResourceNotFoundException;
    void deleteProduct(Long id) throws ResourceNotFoundException;
}
