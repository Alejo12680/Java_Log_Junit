package com.devsenior;

import java.util.ArrayList;
import java.util.List;

import com.devsenior.exceptions.*;


public class Inventory {

  // Atributos
  private List<Product> products;

  // Construtor
  public Inventory() {
    products = new ArrayList<>();
  }

  // Metodos
  public void sellProduct(String name, Integer quantity) throws NotFoundException {
    // Producto existe
    var product = getProductByName(name);

    // No hay cantidad suficiente en el stock 
    if (product.getStock() < quantity) {
      throw new NotEnoughQuantityException("No hay suficiente stock para vender " + quantity + " unidades de " + name);
    } 

    // Coje la cantidad de stock que hay y le resta la cantidad que se quiere vender
    product.setStock(product.getStock() - quantity);

  }

  // Metodo privado para buscar un producto por su nombre tiene una excepcion NotFoundException check
  private Product getProductByName(String name) throws NotFoundException {

    for (var product : products) {
      //  Ignora mayusculas y minusculas para que no genere error
      if (name.equalsIgnoreCase(product.getName())) {
        return product;
      }
    }

    throw new NotFoundException("Producto " + name + " existe en el inventario");
  }

  public void addProduct(Product product) {    
    
    try {
      var currentProduct = getProductByName(product.getName());
      var newQuantity = currentProduct.getStock() + product.getStock(); 
      var newPrice = (currentProduct.getStock() * currentProduct.getPrice() + product.getStock() * product.getPrice()) / newQuantity;

      currentProduct.setStock(newQuantity);
      currentProduct.setPrice(newPrice);

    } catch (Exception e) {
      products.add(product);
    }
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
