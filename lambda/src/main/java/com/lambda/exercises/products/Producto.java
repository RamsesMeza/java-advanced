package com.lambda.exercises.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Product {
  private String name;
  private String category;
  private double price;
  private int stock;
}
