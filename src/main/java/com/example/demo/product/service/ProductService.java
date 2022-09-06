package com.example.demo.product.service;

import org.springframework.stereotype.Service;

import com.example.demo.common.exception.NotFoundException;
import com.example.demo.product.entity.Product;
import com.example.demo.product.repository.ProductRepository;
import com.example.demo.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final UserService userService;
  private final ProductRepository productRepository;

  public void create(Product product) {

    productRepository.save(product);
  }

  public Product findOne(long id) {
    return productRepository
        .findById(id)
        .orElseThrow(NotFoundException::new);
  }

}
