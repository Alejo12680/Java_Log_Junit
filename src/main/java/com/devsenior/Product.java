package com.devsenior;

public class Product {

  // Atributos
  private String name;
  private Integer stock;
  private Double price;

  // Construtor
  public Product(String name, Integer stock, Double price) {
    this.name = name;
    this.stock = stock;
    this.price = price;
  }

  // Metodos de acesso (getters)
  public String getName() {
    return name;
  }

  public Integer getStock() {
    return stock;
  }

  public Double getPrice() {
    return price;
  }

  // Metodos de acesso (setters)
  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

}
