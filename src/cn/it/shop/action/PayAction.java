package cn.it.shop.action;


import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import cn.it.shop.action.BaseAction;
import cn.it.shop.model.BackData;
import cn.it.shop.model.Forder;
import cn.it.shop.model.SendData;
import cn.it.shop.model.User;


@Controller("payAction")
@Scope("prototype")
public class PayAction extends BaseAction<Object> implements ParameterAware {

	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		if(parameters.get("pd_FrpId")!=null){
			model = new SendData();
		}else{
			model = new BackData();
		}
		return model;
	}
	private Map<String, String[]> parameters;
	
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters=parameters;
	}
	public String goBank(){
		SendData sendData = (SendData) model;
		Forder forder = (Forder) session.get("oldForder");
		User user = (User) session.get("user");
		sendData.setP2_Order(forder.getId().toString());
		sendData.setP3_Amt(forder.getTotal().toString());
		sendData.setPa_MP(user.getEmail()+"," +user.getPhone());
		payService.saveDataToRequest(request, sendData);
		return "pay";
	}

	
	
	
	/*private static final long serialVersionUID = -3898532322589046425L;
	
	

	public String send() {
		// 把明文和密文都存储到request Map对象中
		payService.saveDataToRequest(request, model);
		return "reqpay";
	}
	
	public String success() throws Exception {
		boolean isOK=payService.checkBackData(parameters);
		if (isOK) {
			if (parameters.get("r1_Code")[0].equals("1")) { 
				//把 支付成功的订单状态改成已支付,并个给用户显示支付成功信息
				//调用邮件服务接口
				System.out.println("----success !!!-----");
			}
		} else {
			System.out.println("----fail !!!-----");
		}
		return "index";
	}

	*/
}
