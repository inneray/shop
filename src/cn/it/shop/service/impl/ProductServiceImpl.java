package cn.it.shop.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import cn.it.shop.model.Category;
import cn.it.shop.model.Product;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.ProductService;
@SuppressWarnings("unchecked")
@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService{

	@Override
	public List<Product> queryJoinCategory(String name, int page, int size) {
		// TODO Auto-generated method stub
		return getSession()
				.createQuery("from Product p left join fetch p.category where p.name like :name")
				.setString("name", "%"+name+"%")
				.setFirstResult((page-1)*size)
				.setMaxResults(size)
				.list();
	}

	@Override
	public Long count(String name) {
		// TODO Auto-generated method stub
		String hql = "SELECT COUNT(p) FROM Product p WHERE p.name LIKE :name";
		return (Long) getSession().createQuery(hql) //
				.setString("name", "%" + name + "%") //
				.uniqueResult();
	}

	@Override
	public List<Product> queryByCid(int cid) {
		// TODO Auto-generated method stub
		String hql = "from Product p left join fetch p.category where p.commend = true and p.open = true and p.category.id = :cid order by p.date desc";
		//String hql = "from Product p left join fetch p.category where p.open=true and p.commend=true and p.category.id= :cid order";
		return getSession().createQuery(hql)
				.setInteger("cid", cid)
				.setFirstResult(0)
				.setMaxResults(4)
				.list();
	}

	


}
