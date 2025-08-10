package com.ecommerce.service;
import com.ecommerce.model.Order;
import com.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    @Autowired OrderRepository repo;
    public void save(Order o){ repo.save(o); }
    public List<Order> list(){ return repo.findAll(); }
    
    public Order getOrderById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteOrderById(Long id) {
        repo.deleteById(id);
    }

}
