package com.sda.homework0503.repository;

import com.sda.homework0503.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
