package cache;

import dao.ProductDAO;
import daoImpl.ProductDAOImpl;
import model.Product;

// Proxy design pattern is a part of a structural design pattern which will allow us to create a proxy object or a reference object
// that we can use without having too much load on the actual object.
public class ProductDAOProxy implements ProductDAO {
	private ProductDAO productDAOObj;

	public ProductDAOProxy() {
		productDAOObj = new ProductDAOImpl();
	}

	@Override
	public void create(String client, Product product) throws Exception {
		if (client.equals("ADMIN")) {
			productDAOObj.create(client, product);
			return;
		}

		throw new Exception("Access Denied");
	}

	@Override
	public void delete(String client, int productId) throws Exception {
		if (client.equals("ADMIN")) {
			productDAOObj.delete(client, productId);
			return;
		}

		throw new Exception("Access Denied");
	}

	@Override
	public Product get(String client, int productId) throws Exception {
		if (client.equals("ADMIN") || client.equals("USER")) {
			return productDAOObj.get(client, productId);
		}

		throw new Exception("Access Denied");
	}
}
