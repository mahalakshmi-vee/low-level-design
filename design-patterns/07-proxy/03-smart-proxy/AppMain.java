package main;

import dao.ProductDAO;
import model.Product;
import proxy.ProductDAOSmartProxy;

public class AppMain {
	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAOSmartProxy();
		productDAO.create(new Product(1));
		productDAO.create(new Product(2));
		productDAO.get(1);
		productDAO.get(1);
	}
}
