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
import cn.it.shop.service.SorderService;
@SuppressWarnings("unchecked")
@Service("sorderService")
public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements SorderService{

	@Override
	public Sorder productToSorder(Product product) {
		// TODO Auto-generated method stub
		Sorder sorder = new Sorder();
		sorder.setName(product.getName());
		sorder.setNumber(1);
		sorder.setPrice(product.getPrice());
		sorder.setProduct(product);
		return sorder;
	}

	@Override
	public Forder addSorder(Forder forder, Product product) {
		// TODO Auto-generated method stub
		boolean isHave = false;
		Sorder sorder = productToSorder(product);
		if(forder.getSorderSet()!=null){
			for(Sorder old:forder.getSorderSet()){
				if(old.getProduct().getId().equals(sorder.getProduct().getId())){
					old.setNumber(old.getNumber()+sorder.getNumber());
					isHave = true;
					break;
				}
			}
		}
		
		if(!isHave){
			sorder.setForder(forder);
			
			forder.getSorderSet().add(sorder);
		}
		
		return forder;
	}

	

	


}
