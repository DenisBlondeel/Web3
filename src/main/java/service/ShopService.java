package service;

import java.util.List;

import db.PersonRepository;
import db.PersonRepositoryInMemory;
import db.PersonRepositoryInSQL;
import db.ProductRepository;
import db.ProductRepositoryInMemory;
import db.ProductRepositoryInSQL;
import domain.Cart;
import domain.Person;
import domain.Product;
import domain.ProductOrder;

public class ShopService {
	//private PersonRepository personRepository = new PersonRepositoryInMemory();
	//private ProductRepository productRepository = new ProductRepositoryInMemory();
	private PersonRepository personsql = new PersonRepositoryInSQL();
	private ProductRepository productsql = new ProductRepositoryInSQL();
	private Cart cart = new Cart();

	public ShopService(){
	}
	
	public Person getPerson(String personId) {
		return getPersonRepository().get(personId);
	}
	
	public Person getPersonIfAuthenticated(String personId, String password) {
		return getPersonRepository().getIfAuthenticated(personId, password);
	}

	public List<Person> getPersons() {
		return getPersonRepository().getAll();
	}

	public void addPerson(Person person) {
		getPersonRepository().add(person);
	}

	public void updatePersons(Person person) {
		getPersonRepository().update(person);
	}

	public void deletePerson(String id) {
		getPersonRepository().delete(id);
	}

	private PersonRepository getPersonRepository() {
		return personsql;
	}
	
	public Product getProduct(String productId) {
		return getProductRepository().get(productId);
	}

	public List<Product> getProducts() {
		return getProductRepository().getAll();
	}

	public void addProduct(Product produc) {
		getProductRepository().add(produc);
	}

	public void updateProduct(Product produc) {
		getProductRepository().update(produc);
	}

	public void deleteProduct(String id) {
		getProductRepository().delete(id);
	}

	private ProductRepository getProductRepository() {
		return productsql;
	}
	
	public boolean exists(String id)
	{
		return getPersonRepository().exists(id);
	}
	
	private Cart getCart()
	{
		return cart;
	}
	
	public void addProductToCart(Product product, int quantity)
	{
		getCart().addProduct(product, quantity);
	}
	
	public List<ProductOrder> getProductsInCart()
	{
		return getCart().getProductsOrdered();
	}
	public double getTotalAmount()
	{
		return getCart().getTotalPrice();
	}
}
