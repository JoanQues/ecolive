package com.ecolive.dto;

public class Product {
	private int id;
	private String name;
	private String description;
	private double price;
	private double weigth;
	private Category category;
	
	
	public Product() {
		super();
	}


	public Product(int id) {
		super();
		this.id = id;
	}


	public Product(int id, String name, String description, double price, double weigth) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.weigth = weigth;
	}


	public Product(String name, String description, double price, double weigth) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.weigth = weigth;
	}


	public Product(int id, String name, String description, double price, double weigth, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.weigth = weigth;
		this.category = category;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public double getWeigth() {
		return weigth;
	}


	public void setWeigth(double weigth) {
		this.weigth = weigth;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category categoria) {
		this.category = categoria;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", weigth=" + weigth + ", categoria=" + category + "]";
	}
	
}
