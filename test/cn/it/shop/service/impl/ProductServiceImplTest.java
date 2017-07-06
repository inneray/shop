package cn.it.shop.service.impl;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.Account;
import cn.it.shop.model.Category;
import cn.it.shop.model.Product;
import cn.it.shop.service.AccountService;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.ProductService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class ProductServiceImplTest {

	@Resource
	private ProductService productService;
	@Test
	public void testSave() {
		 Product product = new Product();
		 product.setName("hha");
		 product.setDate(new Timestamp(123456));
		productService.save(product);
		
	}

	@Test
	public void testquery() {
		 
		System.out.println(productService);
		
	}
	@Test
	public void testqueryByCid() {
		 
		for( Product temp: productService.queryByCid(1)){
			System.out.println(temp);
		}
		
	}
	

}
