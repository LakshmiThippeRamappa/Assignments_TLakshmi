package com.ecommerce.service;
import com.ecommerce.model.Customer;
import com.ecommerce.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class CustomerService {
    @Autowired CustomerRepository repo;
    public void save(Customer c){ repo.save(c); }
    public List<Customer> list(){ return repo.findAll(); }
    
    public Customer getCustomerById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteCustomerById(Long id) {
        repo.deleteById(id);
    }


}
