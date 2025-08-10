package com.ecommerce.service;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    @Autowired ProductRepository repo;
    public void save(Product p){ repo.save(p); }
    public List<Product> list(){ return repo.findAll(); }
    
    public Product getProductById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteProductById(Long id) {
        repo.deleteById(id);
    }

}
