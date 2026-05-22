package com.optional.finalproject.controller;

import com.optional.finalproject.service.ProductService;
import com.optional.finalproject.view.ProductView;

public class ProductController {
  private final ProductView productView;
  private final ProductService productService;

  public ProductController(ProductView productView, ProductService productService) {
    this.productView = productView;
    this.productService = productService;
  }

  public void start() {

    int option = 0;
    do {
      option = this.productView.showMenu();
    } while (option != 5);
  }

}
