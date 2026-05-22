package com.optional.finalproject.controller;

import java.util.NoSuchElementException;

import com.optional.finalproject.dto.AddProductDto;
import com.optional.finalproject.model.ProductCategory;
import com.optional.finalproject.service.CategoryService;
import com.optional.finalproject.service.ProductService;
import com.optional.finalproject.view.ProductView;

public class ProductController {
  private final ProductView productView;
  private final ProductService productService;
  private final CategoryService categoryService;

  public ProductController(ProductView productView, ProductService productService, CategoryService categoryService) {
    this.productView = productView;
    this.productService = productService;
    this.categoryService = categoryService;
  }

  public void addNewProduct() {

    try {

      this.productView.showMessage("Registering new product\n");
      Long id = this.productView.askNumber("Id: ", Long::parseLong);

      String name = this.productView.askString("Name: ");
      double price = this.productView.askNumber("Price: ", Double::parseDouble);
      int stock = this.productView.askNumber("Stock: ", Integer::parseInt);

      int categoryNumber = this.productView.showCategoryMenu();

      // I don't know if this validation must be ont the service
      ProductCategory category = this.categoryService.getCategoryByNumber(categoryNumber)
          .orElseThrow(() -> new NoSuchElementException("Category not found"));

      AddProductDto addProductDto = new AddProductDto(id, name, price, stock, category);
      this.productService.addProduct(addProductDto);
    } catch (Exception e) {
      this.productView.showErrorMessage(e.getMessage());
    }
  }

  public void listProducts() {
    this.productView.listProducts(this.productService.getAll());
  }

  public void start() {

    int option = 0;
    do {
      try {
        option = this.productView.showMenu();

        switch (option) {
          case 1:
            this.addNewProduct();
            break;

          case 2:
            this.listProducts();
            break;

          case 3:
            this.listProducts();
            break;
          case 4:

            break;

          default:
            break;
        }

      } catch (Exception e) {
        this.productView.showErrorMessage(e.getMessage());
      }
    } while (option != 5);
  }

}
