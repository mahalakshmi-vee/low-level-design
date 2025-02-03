package main;

import cache.ProductDAOVirtualProxy;
import model.Product;

public class AppMain {
	public static void main(String[] args) {
		ProductDAOVirtualProxy productDAO = new ProductDAOVirtualProxy();
		productDAO.create(new Product(1));
		productDAO.create(new Product(2));
		productDAO.get(1);
		productDAO.get(1);
	}
}
