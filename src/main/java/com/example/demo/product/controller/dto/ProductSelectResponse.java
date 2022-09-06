package com.example.demo.product.controller.dto;

import com.example.demo.product.entity.Product;

public record ProductSelectResponse(
    String productName,
    Long quantity,
    Long price,
    String sellerName
) {

  public static ProductSelectResponse from(Product product) {
    return new ProductSelectResponse(
        product.getName(),
        product.getQuantity(),
        product.getPrice(),
        product.getSeller().getName()
    );
  }

}
