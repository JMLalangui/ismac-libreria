package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.*;
import com.distribuida.entities.Cliente;
import com.distribuida.entities.Libro;

@Controller
@RequestMapping("/libro")
public class LibroController {
	
	@Autowired
	private LibroDao libroDao;
	
	@Autowired
	private AutorDao autorDao;
	
	@Autowired
	private CategoriaDao categoriaDao;
	
	@GetMapping("/findAll")
	private String findAll(ModelMap modelMap) {
		List<Libro>libros = libroDao.findAll();
		modelMap.addAttribute("libros", libros);
		return "libros-listar";
	}
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idLibro") @Nullable Integer idLibro
			,@RequestParam("opcion") @Nullable Integer opcion
			, ModelMap modelMap) {
//		try {
				
				if (idLibro != null) {
					Libro libro = libroDao.findOne(idLibro);
					modelMap.addAttribute("libro", libro);
				}
				
				modelMap.addAttribute("autores", autorDao.findAll());
				modelMap.addAttribute("categorias", categoriaDao.findAll());
				
				if (opcion == 1)
					return "libros-add"; 
				else
					return "libros-del";
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
				
				
				
				
	}

}
