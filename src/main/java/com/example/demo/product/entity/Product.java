package com.example.demo.product.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.example.demo.product.controller.dto.ProductCreateRequest;
import com.example.demo.user.entity.User;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Entity
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Long price;

  private Long quantity;

  @OneToOne(fetch = FetchType.LAZY)
  private User seller;

  @Builder
  public Product(
      String name,
      Long price,
      Long quantity
  ) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public static Product from(ProductCreateRequest request) {
    return Product
        .builder()
        .name(request.name())
        .price(request.price())
        .quantity(request.quantity())
        .build();
  }

}
