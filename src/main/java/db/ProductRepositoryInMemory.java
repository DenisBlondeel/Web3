package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Person;
import domain.Product;

public class ProductRepositoryInMemory implements ProductRepository {
	
	private Map<String, Product> products = new HashMap<String, Product>();

	public ProductRepositoryInMemory() {
		add(new Product("dummy", "dummy", 25));
		add(new Product("test", "dummy", 25));
		add(new Product("stoel", "dummy", 25));
		add(new Product("lamp", "dummy", 25));
	}

	@Override
	public Product get(String productId) {
		if(productId == null){
			throw new IllegalArgumentException("No id given");
		}
		return products.get(productId);
	}

	@Override
	public List<Product> getAll() {
		return new ArrayList<Product>(products.values());	
	}

	@Override
	public void add(Product product) {
		if(product == null){
			throw new IllegalArgumentException("No product given");
		}
		if (products.containsKey(product.getProductId())) {
			throw new IllegalArgumentException("product already exists");
		}
		products.put(product.getProductId(), product);
	}

	@Override
	public void update(Product product) {
		if(product == null){
			throw new IllegalArgumentException("No product given");
		}
		if(!products.containsKey(product.getProductId())){
			throw new IllegalArgumentException("No product found");
		}
		products.put(product.getProductId(), product);
	}

	@Override
	public void delete(String productId) {
		if(productId == null){
			throw new IllegalArgumentException("No id given");
		}
		products.remove(productId);
	}

}
