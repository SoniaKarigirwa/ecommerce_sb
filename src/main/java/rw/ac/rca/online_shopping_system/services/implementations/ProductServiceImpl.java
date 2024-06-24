package rw.ac.rca.online_shopping_system.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.ac.rca.online_shopping_system.DTO.ProductDTO;
import rw.ac.rca.online_shopping_system.exceptions.ResourceNotFoundException;
import rw.ac.rca.online_shopping_system.models.Product;
import rw.ac.rca.online_shopping_system.repositories.ProductRepository;
import rw.ac.rca.online_shopping_system.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(ProductDTO productDTO) {
        Product product =productDTO.toEntity();
        return productRepository.save(product);
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) throws ResourceNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", String.valueOf(id)));
    }

    @Override
    public Product updateProduct(Long id, ProductDTO productDetails) throws ResourceNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", String.valueOf(id)));
        product.setCode(productDetails.getCode());
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setInDate(productDetails.getInDate());
        product.setImage(productDetails.getImage());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) throws ResourceNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", String.valueOf(id)));
        productRepository.delete(product);
    }
}
