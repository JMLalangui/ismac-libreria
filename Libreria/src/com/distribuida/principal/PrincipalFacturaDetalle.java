package com.distribuida.principal;

import java.sql.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.*;
import com.distribuida.dao.FacturaDetalleDaoImpl;
import com.distribuida.entities.Factura;
import com.distribuida.entities.FacturaDetalle;

public class PrincipalFacturaDetalle {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		FacturaDetalleDao facturadetalleDao = context.getBean("facturaDetalleDaoImpl",FacturaDetalleDao.class);
		FacturaDao facturaDao = context.getBean("facturaDaoImpl",FacturaDao.class);
		LibroDao libroDao = context.getBean("libroDaoImpl",LibroDao.class);
		
		
		//CRUD
		
		//ADD
		FacturaDetalle facturadetalleADD = new FacturaDetalle(0,12,12.35,null,null);
		facturadetalleDao.add(facturadetalleADD);
		
		//UP
		FacturaDetalle facturadetalleUP = new FacturaDetalle(207,10,12.35,null,null);
		facturadetalleUP.setFactura(facturaDao.findOne(1));
		facturadetalleUP.setLibro(libroDao.findOne(1));
		facturadetalleDao.up(facturadetalleUP);
		
		//DEL
		facturadetalleDao.del(207);
		try {
			System.out.println("*********************** DEL ***********************"+facturadetalleDao.findOne(207));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		//FINDALL
		facturadetalleDao.findAll().forEach(item -> {System.out.println(item.toString());});
		
		
		context.close();
	}
	
	
}
