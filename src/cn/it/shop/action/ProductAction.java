package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.aspectj.util.FileUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Category;
import cn.it.shop.model.Product;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
@Scope("prototype")
public class ProductAction extends BaseAction<Product>{

	public String queryJoinCategory(){
		
	
		jsonMap = new HashMap<String, Object>();
		List<Product> productList = productService
				.queryJoinCategory(model.getName(), page, rows);
		for(int i = 0;i<productList.size();i++)
			
			productList.get(i).getCategory().setAccount(null);
		jsonMap.put("rows", productList);
		jsonMap.put("total", productService.count(model.getName()));
		return "jsonMap";
	}
	
	public void save() throws IOException{
		System.out.println("----ProductAction---save");
		System.out.println(model);
		String pic = fileUpload.uploadFile(fileImage);
		System.out.println(pic);
		model.setPic(pic);
		model.setDate(new Timestamp(System.currentTimeMillis()));
		productService.save(model);
		
		System.out.println("hhe----");
		
		System.out.println(model);
	}
	
	public String get(){
		request.put("product", productService.get(model.getId()));
		return "detail";
	}
	
}





