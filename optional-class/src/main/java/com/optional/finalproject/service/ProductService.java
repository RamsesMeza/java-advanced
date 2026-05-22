package com.optional.finalproject.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.optional.finalproject.dto.AddProductDto;
import com.optional.finalproject.model.Product;
import com.optional.finalproject.model.ProductCategory;
import com.optional.finalproject.repository.ProductRepository;

public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void addProduct(AddProductDto addProductDto) {

    Product product = new Product(
        addProductDto.getId(),
        addProductDto.getName(),
        addProductDto.getPrice(),
        addProductDto.getStock(),
        addProductDto.getCategory());

    this.productRepository.add(product);
  }

  public Product searchProductById(Long id) {
    return this.productRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Product not found"));

  }

  public Product searchProductByName(String name) {
    return this.productRepository.findByName(name)
        .orElseThrow(() -> new NoSuchElementException("Product not found"));
  }

  public List<Product> filterByCategory(ProductCategory category) {
    return this.productRepository.findByCategory(category);
  }

  public int getTotalOfProducts() {
    return this.productRepository.getTotalOfProducts();
  }

  public Double getAveragePrice() {
    return this.productRepository.getAveragePrice();
  }

}
