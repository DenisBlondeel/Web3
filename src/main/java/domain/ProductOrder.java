package domain;

import domain.Product;

public class ProductOrder {
	private Product product;
	private int quantity;

	public ProductOrder(Product product, int quantity) {
		setProduct(product);
		setQuantity(quantity);
	}
	
	public ProductOrder()
	{
		
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public Product getProduct() {
		return product;
	}

	private void setProduct(Product product) {
		this.product = product;
	}

	public double getTotalPrice() {
		return getProduct().getPrice() * getQuantity();
	}

	public String getProductDescription() {
		return getProduct().getDescription();
	}

	public double getProductPrice() {
		return getProduct().getPrice();
	}

	public String getProductId() {
		return getProduct().getProductId();
	}

	public void setPrice(double newPrice) {
		product.setPrice(newPrice);
	}

}