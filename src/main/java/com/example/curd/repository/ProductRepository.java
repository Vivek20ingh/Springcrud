package com.example.curd.repository;

import antlr.collections.List;
import com.example.curd.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    public Product findByName(String name);
//    public Product findByUserId(int id);

}
