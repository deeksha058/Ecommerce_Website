package com.Deeksha.major.service;


import com.Deeksha.major.Repository.ProductRepository;
import com.Deeksha.major.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
}
