package cn.it.shop.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import cn.it.shop.service.BaseService;
@SuppressWarnings("unchecked")
@Service("baseService")
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T>{

	private Class clazz;
	
	public  BaseServiceImpl() {
		// TODO Auto-generated constructor stub
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz=(Class) type.getActualTypeArguments()[0];
	}
	@Resource
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		getSession().save(t);

	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		getSession().update(t);

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String hql = "delete "+clazz.getSimpleName()+" where id=:id";
		getSession().createQuery(hql)
		.setInteger("id", id)
		.executeUpdate();
	}

	@Override
	public T get(int id) {
		// TODO Auto-generated method stub
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> query() {
		// TODO Auto-generated method stub
		String hql = "from "+clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}

}
