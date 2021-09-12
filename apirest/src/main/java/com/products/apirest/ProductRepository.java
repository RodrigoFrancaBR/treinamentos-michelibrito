package com.products.apirest;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.apirest.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
