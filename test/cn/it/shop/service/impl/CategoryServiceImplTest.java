package cn.it.shop.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class CategoryServiceImplTest {

	@Resource
	private CategoryService categoryService;
	@Test
	public void testSave() {
		categoryService.save(new Category("测试一下",true));
	}

	@Test
	public void testUpdate() {
		categoryService.update(new Category(3,"测试一下",true));
	}

	
	@Test
	public void testGet() {
		System.out.println(categoryService.get(3));
	}

	@Test
	public void testQuery() {
			for(Category temp:categoryService.query()){
				System.out.println(temp);
			}
	}
	@Test
	public void testDelete() {
		categoryService.delete(3);
	}

	@Test
	public void queryJoinAccount() {
		for(Category temp:categoryService.queryJoinAccount("",2,2)){
			System.out.println(temp);
			System.out.println(temp.getAccount());
		}
			
	}
	
	@Test
	public void deleteByIdsTest(){
		categoryService.deleteByIds("1,2");
	}
	@Test
	public void  queryByHotTest() {
		// TODO Auto-generated method stub
		System.out.println(categoryService.queryByHot(true));
	}

}
