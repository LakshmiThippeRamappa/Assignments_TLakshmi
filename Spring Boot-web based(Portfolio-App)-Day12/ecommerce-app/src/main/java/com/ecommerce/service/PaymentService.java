package com.ecommerce.service;
import com.ecommerce.model.Payment;
import com.ecommerce.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentService {
    @Autowired PaymentRepository repo;
    public void save(Payment p){ repo.save(p); }
    public List<Payment> list(){ return repo.findAll(); }
    
    public Payment getPaymentById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deletePaymentById(Long id) {
        repo.deleteById(id);
    }

    
}
