package com.distribuida.principal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import com.distribuida.dao.CategoriaDao;
import com.distribuida.dao.CategoriaDaoImpl;
import com.distribuida.entities.Categoria;

public class PrincipalCategoria {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");  
		CategoriaDao categoriaDao = context.getBean("categoriaDaoImpl",CategoriaDao.class);
		
		//CRUD
		//ADD
		//Categoria categoriaADD = new Categoria(0,"lucerito del alba","ni idea");
		//categoriaDao.add(categoriaADD);
		
		//UP
		//Categoria categoriaUP = new Categoria(54,"Ciencias sociales","libros ");
		//categoriaDao.up(categoriaUP);
		
		//DELETE
		//categoriaDao.del(51);
		//try {
		//	System.out.println("********************** DELETE************"+categoriaDao.findOne(51));
		//} catch (Exception e) {
		//	e.printStackTrace();
		//}
		
		
		
		
		
		
		List<Categoria> categorias = categoriaDao.findAll();
		categorias.forEach(item -> {
			System.out.println(item.toString());
		});
		
		context.close();

	}

}
