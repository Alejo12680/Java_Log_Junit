package com.devsenior;

public class Main {
	public static void main(String[] args) {
		
		// Instancia de inventario
		var inventory = new Inventory();
		inventory.addProduct(new Product("Laptop", 10, 1000d));
		
	}
}