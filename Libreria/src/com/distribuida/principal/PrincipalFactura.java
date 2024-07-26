package com.distribuida.principal;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.distribuida.dao.FacturaDao;
import com.distribuida.dao.FacturaDaoImpl;

public class PrincipalFactura {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		FacturaDao facturaDao = context.getBean("facturaDaoImpl",FacturaDao.class);
		
		//CRUD
		//ADD
		
		
		//UP
		
		
		//DELETE
		
		
		//FINDONE
		
		
		
		//FINDALL
		facturaDao.findAll().forEach(item -> {System.out.println(item.toString());});
		
		
		context.close();
	}

}
