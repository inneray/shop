package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
@Scope("prototype")
public class CategoryAction extends BaseAction<Category>{

	
	
	public String queryJoinAccount() throws Exception{
//		Thread.sleep(2000);
		System.out.println("----queryJoinAccount()-----");
		System.out.println("type:" + model.getType() + ",page:" + page + ",rows:" + rows);
		// 结果要返回json格式,此查询级联了account,如果支持分页则返回  "total, "rows" 建议使用Map存储
       //categoryList=categoryService.queryJoinAccount(model.getType());
		jsonMap=new HashMap<String, Object>();
		jsonMap.put("total", categoryService.count(model.getType()));
		jsonMap.put("rows", categoryService.queryJoinAccount(model.getType(), page, rows));
		return "jsonMap";
	}
	
	public String deleteByIds(){
		
		System.out.println(ids);
		categoryService.deleteByIds(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void save(){
		System.out.println(model);
		categoryService.save(model);
		
	}
	
	public void update(){
		System.out.println(model);
		categoryService.update(model);
	}
	public String query(){
		
		jsonList = categoryService.query();
		return "jsonList";
	}
	
}





