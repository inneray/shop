package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Category;
import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;
import cn.it.shop.model.Status;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;
@Controller
@Scope("prototype")
public class SorderAction extends BaseAction<Sorder>{

	
	public String addSorder(){
		
		Product	product = productService.get(model.getProduct().getId());
		if(session.get("forder")==null){
			session.put("forder", new Forder(new HashSet<Sorder>()));
		}
		
		
		Forder forder = (Forder) session.get("forder");
		forder = sorderService.addSorder(forder, product);
		
		forder.setTotal(forderService.cluTotal(forder));
		
		session.put("forder", forder);
		
		return "showCar";
	}
	
}





