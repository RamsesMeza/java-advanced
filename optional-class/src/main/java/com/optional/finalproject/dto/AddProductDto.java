package com.optional.finalproject.dto;

import com.optional.finalproject.model.ProductCategory;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddProductDto {
  private Long id;
  private String name;
  private double price;
  private int stock;
  private ProductCategory category;

  public AddProductDto(Long id, String name, double price, int stock, ProductCategory category) {

    if (id == null) {
      throw new NullPointerException("id can't be null");
    }

    if (name == null || name.isBlank()) {
      throw new NullPointerException("name can't be null ether empty");
    }

    if (category == null) {
      throw new NullPointerException("category can't be null");
    }

    this.id = id;
    this.name = name;
    this.price = price;
    this.stock = stock;
    this.category = category;
  }

}
