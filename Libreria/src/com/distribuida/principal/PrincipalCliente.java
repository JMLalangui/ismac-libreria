package com.distribuida.principal;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.distribuida.dao.ClienteDao;
import com.distribuida.dao.ClienteDaoImpl;
import com.distribuida.entities.Cliente;

public class PrincipalCliente {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");  
		ClienteDao clienteDao = context.getBean("clienteDaoImpl", ClienteDao.class);
		
		//CRUD
				//ADD
				Cliente clienteADD = new Cliente (0,"1234567890","ni idea","lo que sea","donde sea","0987654321","quienseagmail.com");
				clienteDao.add(clienteADD);
				
				//UP
				Cliente clienteUP = new Cliente (0,"1234567890","ni idea","lo que sea","donde sea","0987654321","quienseagmail.com");
				clienteDao.up(clienteUP);
				
				//DELETE
				clienteDao.del(51);
				try {
					System.out.println("********************** DELETE************"+clienteDao.findOne(51));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		
		
		
		
		
		
		List<Cliente> clientes = clienteDao.findAll();
		clientes.forEach(item -> {
			System.out.println(item.toString());
		});
		
		context.close();

	}

}
