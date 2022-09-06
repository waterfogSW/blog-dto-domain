package com.example.demo.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.product.controller.dto.ProductSelectResponse;
import com.example.demo.product.entity.Product;
import com.example.demo.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductRestController {

  private final ProductService productService;

  @GetMapping("{id}")
  public ProductSelectResponse selectOne(
      @PathVariable long id
  ) {
    Product product = productService.findOne(id);
    return ProductSelectResponse.from(product);
  }

}
