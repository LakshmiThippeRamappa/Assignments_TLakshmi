package com.ecommerce.repository;
import com.ecommerce.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
