package dao;

import model.Product;

public interface ProductDAO {
	void create(String client, Product product) throws Exception;

	void delete(String client, int productId) throws Exception;

	Product get(String client, int productId) throws Exception;
}
