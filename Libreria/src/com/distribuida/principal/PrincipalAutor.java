package com.distribuida.principal;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.AutorDao;
import com.distribuida.dao.AutorDaoImpl;
import com.distribuida.entities.Autor;

public class PrincipalAutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml"); 
		AutorDao autorDao = context.getBean("autorDaoImpl",AutorDao.class);
		
		
		//CRUD
				//ADD
				//Autor autorADD = new Autor(0,"nutella","peña","ecuador","ascazubi","0987654321","nutella@gmail.com");
				//autorDao.add(autorADD);
				
				//UP
				//Autor autorUP = new Autor(53,"nutella nutella","peña","ecuador","ascazubi","0987654321","nutella@gmail.com");
				//autorDao.up(autorUP);
				
				//DELETE
				//autorDao.del(53);
				//try {
				//	System.out.println("********************** DELETE************"+autorDao.findOne(53));
				//} catch (Exception e) {
				//	e.printStackTrace();
				//}
		
		
		
		
		
		
		List<Autor> autores = autorDao.findAll();
		autores.forEach(item -> {
			System.out.println(item.toString());
		});
		
		context.close();
	}

}
