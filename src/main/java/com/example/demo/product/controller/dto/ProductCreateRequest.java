package com.example.demo.product.controller.dto;

public record ProductCreateRequest(
    String name,
    Long price,
    Long quantity
) {

}
