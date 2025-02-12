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
      /*
       * // Convierne el nombre a minusculas y compara si son iguales
       * 
       * if (name.toLowerCase().equals(product.getName().toLowerCase())) {
       * return product;
       * }
       */

      //  Ignora mayusculas y minusculas para que no genere error
      if (name.equalsIgnoreCase(product.getName())) {

        return product;
      }
    }

    // Es mala practica retornar null
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
