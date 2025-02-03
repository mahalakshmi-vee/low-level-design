package main;

import cache.ProductDAOProxy;
import dao.ProductDAO;
import model.Product;

public class AppMain {
	public static void main(String[] args) {
		try {
			ProductDAO productDAO = new ProductDAOProxy();
			productDAO.create("ADMIN", new Product());
			System.out.println("Operation Successful");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
