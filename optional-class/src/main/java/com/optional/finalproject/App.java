package com.optional.finalproject;

import com.optional.finalproject.controller.ProductController;
import com.optional.finalproject.repository.ProductRepository;
import com.optional.finalproject.service.ProductService;
import com.optional.finalproject.view.ProductView;

public class App {

  public static void main(String[] args) {
    ProductView productView = new ProductView();

    ProductRepository productRepository = new ProductRepository();
    ProductService productService = new ProductService(productRepository);

    ProductController productController = new ProductController(productView, productService);

    productController.start();
  }

}
