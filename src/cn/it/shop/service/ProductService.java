package cn.it.shop.service;

import java.util.List;

import cn.it.shop.model.Category;
import cn.it.shop.model.Product;

public interface ProductService extends BaseService<Product>{

	public List<Product> queryJoinCategory(String name,int page,int size);
	
	public Long count(String name);
	
	public List<Product> queryByCid(int cid);
}
