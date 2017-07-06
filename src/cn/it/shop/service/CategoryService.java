package cn.it.shop.service;

import java.util.List;

import cn.it.shop.model.Category;

public interface CategoryService extends BaseService<Category>{

	//查询类别信息，级联管理员account
	public List<Category> queryJoinAccount(String type,int page ,int size);
	public Long count(String type) ;
	public void deleteByIds(String ids);
	public List<Category> queryByHot(boolean hot);
}
