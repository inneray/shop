package cn.it.shop.service;

import java.util.List;

import cn.it.shop.model.Category;
import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;

public interface ForderService extends BaseService<Forder>{

	public  double cluTotal(Forder forder);
}
