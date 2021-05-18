package com.Shop.demo;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ItemRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ShopRepository repo;
	
	@Test
	
	public void testItem()
	{
		ShopItems item = new ShopItems();
		item.setItemName("milk");
		item.setPrice(40);
		item.setStock(10);
		
		ShopItems savedItem = repo.save(item);
		ShopItems existItem = entityManager.find(ShopItems.class, savedItem.getItemName());
		
		assertThat(item.getItemName()).isEqualTo(existItem.getItemName());
		
	}
	
}
