package domain;

public class Product {
	private String productId;
	private String description;
	private double price;

	public Product(String productId, String description, double price)
	{

		setProductId(productId);
		setDescription(description);
		setPrice(price);
	}

	public Product()
	{

	}

	public String getProductId()
	{
		return productId;
	}

	public void setProductId(String productId)
	{
		if (productId.isEmpty())
		{
			throw new IllegalArgumentException("No productId given");
		}
		this.productId = productId;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		if (description.isEmpty())
		{
			throw new IllegalArgumentException("No description given");
		}
		this.description = description;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		if (price <= 0)
		{
			throw new IllegalArgumentException("price can not be less than zero");
		}
		this.price = price;
	}

}
