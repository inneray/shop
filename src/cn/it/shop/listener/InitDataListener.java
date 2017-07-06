package cn.it.shop.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.it.shop.model.Category;
import cn.it.shop.model.Product;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.ProductService;
import cn.it.shop.util.FileUpload;
import cn.it.shop.util.ProductTimerTask;


public class InitDataListener implements ServletContextListener {

	private ApplicationContext context = null;
	private ProductTimerTask productTimerTask = null;
	private FileUpload fileUpload = null;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		 context = WebApplicationContextUtils
					.getWebApplicationContext(event.getServletContext());
		productTimerTask = (ProductTimerTask) context.getBean("productTimerTask");
		fileUpload = (FileUpload) context.getBean("fileUpload");
		
		productTimerTask.setApplication(event.getServletContext());

		new Timer(true).schedule(productTimerTask, 0, 1000*60*60);
		
	
		
		event.getServletContext().setAttribute("bankList", fileUpload.getBankImage());
		
	}

	/*
	 * [  
	 * 	 1  [Product [id=1, name=圣得西服, price=2999.0, pic=test.jpg, remark=这里是简单介绍, xremark=这里是详细介绍,
	 * 			 date=2017-03-14 17:29:46.0, commend=true, open=true, category=Category [id=1, type=男士休闲, hot=true]], 
	 * 		Product [id=2, name=罗蒙西服, price=1999.0, pic=test.jpg, remark=这里是简单介绍, xremark=这里是详细介绍, 
	 * 			date=2017-03-14 17:29:46.0, commend=true, open=true, category=Category [id=1, type=男士休闲, hot=true]], 
	 * 		Product [id=3, name=衫衫西服, price=3999.0, pic=test.jpg, remark=这里是简单介绍, xremark=这里是详细介绍, 
	 * 			date=2017-03-14 17:29:46.0, commend=true, open=true, category=Category [id=1, type=男士休闲, hot=true]], 
	 * 		Product [id=4, name=金利来西服, price=4999.0, pic=test.jpg, remark=这里是简单介绍, xremark=这里是详细介绍, 
	 * 			date=2017-03-14 17:29:46.0, commend=true, open=true, category=Category [id=1, type=男士休闲, hot=true]]
	 * 		], 
	 * 
	 * 	2	[Product [id=5, name=韩版女装, price=199.0, pic=test.jpg, remark=这里是简单介绍, xremark=这里是详细介绍, 
	 * 			date=2017-03-14 17:29:46.0, commend=true, open=true, category=Category [id=2, type=女士休闲, hot=true]], 
	 * 		Product [id=6, name=雪地靴, price=299.0, pic=test.jpg, remark=这里是简单介绍, xremark=这里是详细介绍, 
	 * 			date=2017-03-14 17:29:46.0, commend=true, open=true, category=Category [id=2, type=女士休闲, hot=true]], 
	 * 		Product [id=7, name=欧版女装, price=3999.0, pic=test.jpg, remark=这里是简单介绍, xremark=这里是详细介绍, 
	 * 			date=2017-03-14 17:29:46.0, commend=true, open=true, category=Category [id=2, type=女士休闲, hot=true]], 
	 * 		Product [id=8, name=女款手套, price=4999.0, pic=test.jpg, remark=这里是简单介绍, xremark=这里是详细介绍, 
	 * 			date=2017-03-14 17:29:46.0, commend=true, open=true, category=Category [id=2, type=女士休闲, hot=true]]
	 * 		], 
	 * 
	 * 	3	[Product [id=9, name=佳能单反机, price=3998.0, pic=test.jpg, remark=这里是简单介绍, xremark=这里是详细介绍, 
	 * 			date=2017-03-14 17:29:46.0, commend=true, open=true, category=Category [id=3, type=儿童休闲, hot=true]], 
	 * 		Product [id=10, name=金士顿优盘, price=299.0, pic=test.jpg, remark=这里是简单介绍, xremark=这里是详细介绍, 
	 * 			date=2017-03-14 17:29:46.0, commend=true, open=true, category=Category [id=3, type=儿童休闲, hot=true]], 
	 * 		Product [id=11, name=日立硬盘, price=599.0, pic=test.jpg, remark=这里是简单介绍, xremark=这里是详细介绍, 
	 * 			date=2017-03-14 17:29:46.0, commend=true, open=true, category=Category [id=3, type=儿童休闲, hot=true]], 
	 * 		Product [id=12, name=大水牛机箱, price=399.0, pic=test.jpg, remark=这里是简单介绍, xremark=这里是详细介绍, 
	 * 			date=2017-03-14 17:29:46.0, commend=true, open=true, category=Category [id=3, type=儿童休闲, hot=true]]
	 * 		]
	 * ]

	 * 
	 * */
}
