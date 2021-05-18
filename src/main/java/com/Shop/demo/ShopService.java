package com.Shop.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
	
	
	@Autowired
	ShopRepository repo;
	
	public int getPrice(String itemName) {
		
	
		ShopItems item = repo.findByItemName(itemName);
		int itemPrice = item.getPrice();
		return itemPrice;
	}
	
	public boolean itemAvailabel(String itemName)
	{
		ShopItems item = repo.findByItemName(itemName);
		int itemStock = item.getStock();
		boolean itemAvailable;
		if(itemStock>0)
			itemAvailable = true;
		else
			itemAvailable = false;
		
		return itemAvailable;
		
	}
	
	public String getItemInfo(String itemName)
	{
		ShopItems item = repo.findByItemName(itemName);
		String info = item.getItemInfo();
		return info;
	}
	
	public int getFinalTotal(int itemQuantity, String itemName)
	{
		ShopItems item = repo.findByItemName(itemName);
		int itemPrice = item.getPrice();
		int finalPrice = itemPrice * itemQuantity;
		int stock = item.getStock();
		int stockLeft = stock - itemQuantity;
		item.setStock(stockLeft);
		repo.save(item);
		return finalPrice;
		
		
		
	}
	

}
