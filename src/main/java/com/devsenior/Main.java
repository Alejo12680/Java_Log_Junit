package com.devsenior;

public class Main {
	public static void main(String[] args) {
		
		// Instancia de inventario
		var inventory = new Inventory();

		// Agrega productos al inventario
		inventory.addProduct(new Product("Laptop", 10, 1000d));
		inventory.addProduct(new Product("Mouse", 50, 20d));

		// Vende un producto
		inventory.sellProduct("Laptop", 5);
		inventory.sellProduct("Mouse", 10);
		inventory.sellProduct("Dummy", 9);

		// Calcula el valor total del inventario
		var total = inventory.calculateTotalInventory();
		System.out.printf("Valor total del inventario es: $ %.2f%n" , total);	

	}
}