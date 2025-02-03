package proxy;

import java.util.logging.Logger;

import dao.ProductDAO;
import daoImpl.ProductDAOImpl;
import model.Product;

public class ProductDAOSmartProxy implements ProductDAO {
	private ProductDAO productDAOObj;
	private static Logger logger = Logger.getLogger(ProductDAOSmartProxy.class.getName());

	public ProductDAOSmartProxy() {
		productDAOObj = new ProductDAOImpl();
	}

	@Override
	public void create(Product product) {
		logger.info("Creating product with ID: " + product.getId());
		productDAOObj.create(product);
		logger.info("Product created successfully.");
	}

	@Override
	public void delete(int productId) {
		logger.info("Deleting product with ID: " + productId);
		productDAOObj.delete(productId);
		logger.info("Product deleted successfully.");
	}

	@Override
	public Product get(int productId) {
		logger.info("Fetching product with ID: " + productId);
		Product product = productDAOObj.get(productId);
		logger.info("Product retrieval successful.");
		return product;
	}

}
