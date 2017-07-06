package cn.it.ssh;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.crypto.Data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.org.apache.bcel.internal.generic.NEW;

import sun.net.www.content.audio.aiff;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.impl.CategoryServiceImpl;


public class SSHTest {

	

	@Test
	public void test(){
		/*byte b1 = 0x7f;//127
		byte b2 = 0x00;//0
		byte b3 = 0x10;//-127
		//byte b4 = 0xff;//-1
		//byte b5 = 0x80;//-128
		Byte byte1 = -128;
		
		Integer i = new Integer((int) (Math.pow(2, 32)+0.5));
		//System.out.println(i.toBinaryString(i));
	
		System.out.println(methoda());*/
		/*Dev Dev1 = new Dev();
		Dev Dev2 = new Dev();
		Dev Dev3 = new Dev();*/
		new Child("mike");

	}
	
	public int methoda(){
		chs a1 = new chs();
		try {
			a1.a++;
			return a1.a;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			a1.a++;
			System.out.println(a1.a);
		}
		return 1;
	}
}
class People {
    String name;

    public People() {
        System.out.print(1);
    }

    public People(String name) {
        System.out.print(2);
        this.name = name;
    }
}

class Child extends People {
    People father;

    public Child(String name) {
        System.out.print(3);
        this.name = name;
        father = new People(name + ":F");
    }

    public Child() {
        System.out.print(4);
    }
    
}
class chs{
	Integer a = new Integer(10);
}
 class Dev {  
    static {  
        System.out.println("静态代码块");  
    }  
    {  
        System.out.println("构造代码块");  
    }  
  
    public Dev() {  
        System.out.println("我是一个无参构造方法");  
    }  
   
    public Dev(String name) {  
        System.out.println("我是带有一个参数的构造方法");  
    }  
}  

