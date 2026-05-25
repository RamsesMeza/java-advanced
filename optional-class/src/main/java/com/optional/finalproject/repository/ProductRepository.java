package com.optional.finalproject.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.optional.finalproject.model.Product;
import com.optional.finalproject.model.ProductCategory;

public class ProductRepository {
  private final List<Product> products;

  public ProductRepository() {
    this.products = new ArrayList<>();
  }

  public void add(Product product) {
    this.products.add(product);

  }

  public void remove(Product product) {
    this.products.remove(product);
  }

  // Tinking if pass the Product complealty is correct or only with id
  public void update(Product product) {

    Optional<Product> oldProduct = this.products.stream().filter(p -> product.getId().equals(p.getId())).findFirst();

    // Dont know if this validation lives here, becase could be and database error

    int indexToDelete = this.products
        .indexOf(oldProduct.orElseThrow(() -> new NoSuchElementException("DB: Product not found")));
    this.products.set(indexToDelete, product);
  }

  public Optional<Product> findByName(String name) {

    return this.products.stream()
        .filter(p -> p.getName().contains(name))
        .findFirst();
  }

  public Optional<Product> findById(Long id) {
    return this.products.stream()
        .filter(p -> id.equals(p.getId()))
        .findFirst();
  }

  public List<Product> getAll() {
    return new ArrayList<>(this.products);
  }

  public List<Product> findByCategory(ProductCategory category) {

    List<Product> filteredList = this.products.stream()
        .filter(p -> category.equals(p.getCategory()))
        .toList();

    return new ArrayList<>(filteredList);

  }

  public List<Product> findByPrice(double price) {
    List<Product> filteredList = this.products.stream()
        .filter(p -> price > p.getPrice())
        .toList();

    return new ArrayList<>(filteredList);
  }

  public int getTotalOfProducts() {
    return this.products.size();
  }

  public double getAveragePrice() {
    Double total = this.products.stream()
        .mapToDouble(p -> p.getPrice())
        .sum();

    Double average = total / this.products.size();

    return average;
  }

  // public double averageByCategory() {

  // }

}
