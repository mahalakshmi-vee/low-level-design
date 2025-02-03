package daoImpl;

import dao.ProductDAO;
import model.Product;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public void create(String client, Product product) {

		// creates a new row
		System.out.println("created new row in the Product table");
	}

	@Override
	public void delete(String client, int productId) {

		// delete a row
		System.out.println("deleted row with productID: " + productId);
	}

	@Override
	public Product get(String client, int productId) {

		// fetch row
		System.out.println("fetching data from the DB");
		return new Product();
	}

}
