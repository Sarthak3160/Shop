package com.Shop.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.Shop.demo.ShopItems;

public interface ShopRepository extends JpaRepository<ShopItems, String >{
	 @Query("SELECT u FROM ShopItems u WHERE u.itemName = ?1") 
	ShopItems findByItemName(String itemName);
}
