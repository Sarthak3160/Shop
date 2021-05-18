package com.Shop.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShopController {
	
	@Autowired
	ShopService order;
	
	
	@Autowired 
	ShopRepository repo;

	String currentItemName;
	
	@RequestMapping("/")
	public String homePage() {
		return "homepage";
	}

	
	/*
	 * @RequestMapping("/DetailsPage") public String viewDetails(String itemName,
	 * ModelAndView mv) { ShopItems item = new ShopItems(); item =
	 * repo.findByItemName(itemName); int itemPrice = item.getPrice();
	 * mv.addObject("ItemPrice", itemPrice); mv = new ModelAndView("iteminfo");
	 * return mv; }
	 */
	 
	
	
	@GetMapping("/DetailsPage/{name}")
	public ModelAndView viewDetails(@PathVariable("name") String itemName, ModelAndView mv)
	{
		ShopItems item = new ShopItems();
		item = repo.findByItemName(itemName);
		currentItemName = itemName;
		String name = itemName;
		int itemPrice = order.getPrice(name);
		String itemInfo = order.getItemInfo(itemName);
		
		mv = new ModelAndView("iteminfo");
		mv.addObject("itemprice", itemPrice);
		mv.addObject("iteminfo", itemInfo);
		mv.addObject("itemname", name);
		return mv;
	}
	
	
	@RequestMapping("/checkout")
	public ModelAndView checkout(@RequestParam int quantity, ModelAndView mv)
	{	
		int finalPrice = order.getFinalTotal(quantity, currentItemName);
		int itemPrice = order.getPrice(currentItemName);
		mv = new ModelAndView("checkout");
		mv.addObject("finaltotal", finalPrice);
		mv.addObject("itemquantity", quantity);
		mv.addObject("itemname",currentItemName );
		mv.addObject("itemprice", itemPrice);
		return mv;
	}
}
