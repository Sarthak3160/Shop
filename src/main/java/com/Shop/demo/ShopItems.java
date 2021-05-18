package com.Shop.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "ShopItems")
public class ShopItems {
	
	@Id
	@Column(nullable = false, unique = true, length = 45)
	private String itemName;
	
	@Column(nullable = false)
	private int price;
	
	@Column(nullable = false)
	private int stock;
	
	@Column(nullable = false, unique = true, length = 200)
	private String itemInfo;
	
	
	
	public ShopItems() {
		super();
	}

	public String getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public int getPrice() {
		return price;
	}
 void setPrice(int price) {
		this.price = price;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}

	

	
	
	 

}
