package com.optional.finalproject.service;

import java.util.Optional;

import com.optional.finalproject.model.ProductCategory;

public class CategoryService {

  public CategoryService() {
  }

  public Optional<ProductCategory> getCategoryByNumber(int n) {

    switch (n) {
      case 1:
        return Optional.of(ProductCategory.ELECTRONICS);
      case 2:
        return Optional.of(ProductCategory.CLOTHING);
      case 3:
        return Optional.of(ProductCategory.FOOD);

      default:
        return Optional.empty();
    }
  }

}
