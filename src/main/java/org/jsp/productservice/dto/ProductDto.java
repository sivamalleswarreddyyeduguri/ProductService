package org.jsp.productservice.dto;

import java.io.Serializable;

public class ProductDto implements Serializable{
	
	private Long altKey;

	private String name;
	
	private Double price;
	
	private Integer quantity;
	
	private String desc;

	public Long getAltKey() {
		return altKey;
	}

	public void setAltKey(Long altKey) {
		this.altKey = altKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "ProductDto [name=" + name + ", price=" + price + ", quantity=" + quantity + ", desc=" + desc + "]";
	}
	
	
}
