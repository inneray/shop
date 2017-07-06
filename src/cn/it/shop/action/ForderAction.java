package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.sql.Timestamp;
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
import cn.it.shop.model.User;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;
@Controller
@Scope("prototype")
public class ForderAction extends BaseAction<Forder>{

	
	@Override
	public Forder getModel() {
		
		model = (Forder) session.get("forder");
		return model;
	};
	
	public String save(){
		
		//Forder forder = (Forder) session.get("forder");
		//model.setSorderSet(forder.getSorderSet());
		model.setUser((User) session.get("user"));
		model.setStatus(new Status(1));
		model.setDate(new Timestamp(System.currentTimeMillis()));
		forderService.save(model);
		
		session.put("oldForder", session.get("forder"));
		session.put("forder", new Forder(new HashSet<Sorder>()));
		return "bank";
	}
	
}





