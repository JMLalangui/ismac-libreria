package com.distribuida.principal;


import java.sql.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.distribuida.dao.FacturaDao;
import com.distribuida.dao.FacturaDaoImpl;
import com.distribuida.dao.ClienteDao;
import com.distribuida.dao.ClienteDaoImpl;
import com.distribuida.entities.Cliente;
import com.distribuida.entities.Factura;

public class PrincipalFactura {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		FacturaDao facturaDao = context.getBean("facturaDaoImpl",FacturaDao.class);
		ClienteDao clienteDao = context.getBean("clienteDaoImpl",ClienteDao.class);
		
		//CRUD
		
		//ADD
		//Factura facturaADD = new Factura(0,"FAC-00073",new Date(0),20.36,5.5,26.35,null);
		//facturaADD.setCliente(clienteDao.findOne(3));
		//facturaDao.add(facturaADD);
		
		//UP
		//Factura facturaUP = new Factura(83,"FAC-00070",new Date(0),20.36,5.5,26.35, null);
		//facturaUP.setCliente(clienteDao.findOne(2));
		//facturaDao.up(facturaUP);
		
		//DELETE
		//facturaDao.del(84);
		//try {
		//	System.out.println("*********************** DEL ***********************"+facturaDao.findOne(83));
		//} catch (Exception e) {
		//	e.printStackTrace();
		//}
		
		
		
		//FINDALL
		facturaDao.findAll().forEach(item -> {System.out.println(item.toString());});
		
		
		context.close();
	}

}
