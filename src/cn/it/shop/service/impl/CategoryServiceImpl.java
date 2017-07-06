package cn.it.shop.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
@SuppressWarnings("unchecked")
@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService{

	@Override
	public List<Category> queryJoinAccount(String type,int page ,int size) {
		// TODO Auto-generated method stub
		return getSession()
		.createQuery("from Category c left join fetch c.account where c.type like :type")
		.setString("type", "%"+type+"%")
		.setFirstResult((page-1)*size)
		.setMaxResults(size)
		.list();
	}

	public Long count(String type) {
		String hql = "SELECT COUNT(c) FROM Category c WHERE c.type LIKE :type";
		return (Long) getSession().createQuery(hql) //
				.setString("type", "%" + type + "%") //
				.uniqueResult();
	}

	@Override
	public void deleteByIds(String ids) {
		// TODO Auto-generated method stub
		String hql = "delete from Category where id in ("+ids+")";
		getSession().createQuery(hql)
		.executeUpdate();
		
	}

	@Override
	public List<Category> queryByHot(boolean hot) {
		// TODO Auto-generated method stub
		String hql = "from Category c  where c.hot = :hot";
		return getSession()
				.createQuery(hql)
				.setBoolean("hot", hot)
				.list();
	}



}
