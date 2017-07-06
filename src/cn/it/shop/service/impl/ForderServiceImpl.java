package cn.it.shop.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import cn.it.shop.model.Category;
import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.ForderService;
import cn.it.shop.service.ProductService;
@SuppressWarnings("unchecked")
@Service("forderService")
public class ForderServiceImpl extends BaseServiceImpl<Forder> implements ForderService{

	@Override
	public double cluTotal(Forder forder) {
		// TODO Auto-generated method stub
		double total = 0.0;
		for(Sorder sorder:forder.getSorderSet()){
			total += sorder.getNumber()*sorder.getPrice();
		}
		return total;
	}

	


}
