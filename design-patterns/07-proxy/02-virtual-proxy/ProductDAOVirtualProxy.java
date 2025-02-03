package cache;

import java.util.HashMap;
import java.util.Map;

import dao.ProductDAO;
import daoImpl.ProductDAOImpl;
import model.Product;

public class ProductDAOVirtualProxy implements ProductDAO {
	private ProductDAO productDAO;
	private Map<Integer, Product> cachedProduct;

	public ProductDAOVirtualProxy() {
		this.productDAO = new ProductDAOImpl();
		cachedProduct = new HashMap<Integer, Product>();
	}

	@Override
	public void create(Product product) {
		productDAO.create(product);
		cachedProduct.put(product.getId(), product);
	}

	@Override
	public void delete(int productId) {
		cachedProduct.remove(productId);
		productDAO.delete(productId);
	}

	@Override
	public Product get(int productId) {
		if (cachedProduct.containsKey(productId)) {
			System.out.println("product retrieval from cache");
			return cachedProduct.get(productId);
		}
		System.out.println("product retrieval from database");
		Product product = productDAO.get(productId);
		cachedProduct.put(productId, product);
		return product;
	}
}
