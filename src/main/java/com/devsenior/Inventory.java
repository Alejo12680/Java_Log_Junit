package com.devsenior;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

  // Atributos
  private List<Product> products;

  // Construtor
  public Inventory() {
    products = new ArrayList<>();
  }

  // Metodos
  public void sellProduct(String name, Integer quantity) {
    // Producto existe
    var product = getProductByName(name);

    // cantidad de stock que hay es mayor o igual a la cantidad que se quiere vender
    if (product.getStock() > quantity) {
      // Coje la cantidad de stock que hay y le resta la cantidad que se quiere vender
      product.setStock(product.getStock() - quantity);

    } else {
      System.out.println("Cantidad insuficiente en stock");

    }
  }

  // Metodo privado para buscar un producto por su nombre
  private Product getProductByName(String name) {
    for (var product : products) {
      if (name.equals(product.getName())) {
        return product;
      }
    }

    return null;
  }

  public void addProduct(Product product) {
    products.add(product);
  }

  public Double calculateTotalInventory() {
    var total = 0d;

    for (var product : products) {
      // Suma el precio del producto por la cantidad de stock que hay
      total += product.getPrice() * product.getStock();
    }

    return total;
  }

}
