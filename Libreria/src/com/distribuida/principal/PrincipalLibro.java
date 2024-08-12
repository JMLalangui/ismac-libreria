package com.distribuida.principal;

import java.sql.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.CategoriaDao;
import com.distribuida.dao.LibroDao;
import com.distribuida.entities.Libro;
import com.distribuida.dao.AutorDao;

public class PrincipalLibro {

	public static void main(String[] args) {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	LibroDao libroDao = context.getBean("libroDaoImpl",LibroDao.class);
	CategoriaDao categoriaDao = context.getBean("categoriaDaoImpl",CategoriaDao.class);
	AutorDao autorDao = context.getBean("autorDaoImpl",AutorDao.class);
	
	//CRUD
	//ADD
	//Libro libroADD = new Libro(0, "sdfghjk", "fghjk", 123, "dfghjk", "sdfghj", new Date(0), "fghjklñ", "qwertyu", "okmnjiuhb",null, "qsdcvbnk", "fghvdrv", 12.5, null, null);
	//libroDao.add(libroADD);
	
	//UP
	//Libro libroUP = new Libro(73, "hola que hace", "fghjk", 123, "dfghjk", "sdfghj", new Date(0), "fghjklñ", "qwertyu", "okmnjiuhb",null, "qsdcvbnk", "fghvdrv", 12.5, null, null);
	//libroUP.setAutor(autorDao.findOne(1));
	//libroUP.setCategoria(categoriaDao.findOne(1));
	//libroDao.up(libroUP);
	
	//DEL
	//libroDao.del(73);
	//try {
	//	System.out.println("*********************** DEL ***********************"+libroDao.findOne(73));
	//} catch (Exception e) {
	//	e.printStackTrace();
	//}
	
	
	//FINDALL
	
	libroDao.findAll().forEach(item -> {System.out.println(item.toString());});
	
	
	context.close();
	


	}
}