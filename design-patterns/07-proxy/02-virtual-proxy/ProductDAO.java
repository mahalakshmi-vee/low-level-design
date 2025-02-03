package dao;

import model.Product;

public interface ProductDAO {
	void create(Product product);

	void delete(int productId);

	Product get(int productId);
}
