package com.devsenior;

import org.slf4j.LoggerFactory;
import com.devsenior.exceptions.NotFoundException;
import com.devsenior.exceptions.NotEnoughQuantityException;

public class Main {
	public static void main(String[] args) {

		var logger = LoggerFactory.getLogger(Main.class);
		logger.trace("Iniciando la aplicación");

		logger.info("Creando el inventario de productos");
		// Instancia de inventario
		var inventory = new Inventory();

		// Agrega productos al inventario
		logger.debug("Agregando producto: {}, cantidad: {}, precio: {}", "Laptop", 10, 1000d);
		inventory.addProduct(new Product("Laptop", 10, 1000d));

		logger.debug("Agregando producto: {}, cantidad: {}, precio: {}", "Mouse", 50, 20d);
		inventory.addProduct(new Product("Mouse", 50, 20d));

		logger.debug("Agregando producto: {}, cantidad: {}, precio: {}", "Monitor", 0, 500d);
		inventory.addProduct(new Product("Monitor", 0, 500d));

		// Vende un producto, si no hay suficiente cantidad lanza una excepción
		try {
			logger.debug("Vendiendo producto: {}, cantidad: {}", "Laptop", 5);
			inventory.sellProduct("Laptop", 5);
			logger.info("Se vendieron 5 laptops");
		} catch (NotFoundException | NotEnoughQuantityException e) {
			logger.error(e.getMessage(), e);
			System.out.println(e.getMessage());
		}
		
		try {
			logger.debug("Vendiendo producto: {}, cantidad: {}", "Monitor", 1);
			inventory.sellProduct("Monitor", 1);
			logger.info("Se vendió 1 monitor");
		} catch (NotFoundException | NotEnoughQuantityException e) {
			logger.error(e.getMessage(), e);
			System.out.println(e.getMessage());
		} 

		try {
			logger.debug("Vendiendo producto: {}, cantidad: {}", "Mouse", 10);
			inventory.sellProduct("Mouse", 10);
			logger.info("Se vendieron 10 mouses");
		} catch (NotFoundException | NotEnoughQuantityException e) {
			logger.error(e.getMessage(), e);
			System.out.println(e.getMessage());
		} 


		// Calcula el valor total del inventario
		var total = inventory.calculateTotalInventory();
		System.out.printf("Valor total del inventario es: $ %.2f%n" , total);	
		logger.debug("Valor total del inventario es: $ {}", String.format("%,.2f", total));

		logger.trace("Finalizando la aplicación");

	}
}