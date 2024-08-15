package com.distribuida.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.distribuida.dao.*;
import com.distribuida.entities.*;

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
	
	@PostMapping("/add")
	public String add(@RequestParam("idLibro") @Nullable Integer idLibro
			 , @RequestParam(" titutlo") @Nullable String titulo
			 , @RequestParam(" editorial") @Nullable String editorial
			 , @RequestParam(" numPaginas") @Nullable Integer numPaginas
			 , @RequestParam(" edicion") @Nullable String edicion
			 , @RequestParam(" idioma") @Nullable String idioma
			 , @RequestParam(" fechaPublicacion") @Nullable Date fechaPublicacion
			 , @RequestParam(" descripcion") @Nullable String descripcion
			 , @RequestParam(" tipoPasta") @Nullable String tipoPasta
			 , @RequestParam(" isbn") @Nullable String isbn
			 , @RequestParam(" numEjemplares") @Nullable Integer numEjemplares
			 , @RequestParam(" portada") @Nullable String portada
			 , @RequestParam(" presentacion") @Nullable String presentacion
			 , @RequestParam(" precio") @Nullable Double precio
			 , @RequestParam(" idAutor") @Nullable Integer idAutor
			 , @RequestParam(" idCategoria") @Nullable Integer idCategoria

			) {
		
		if(idLibro ==  null) {
			Libro libro = new Libro(0, titulo, editorial, numPaginas, edicion, idioma, fechaPublicacion
					, descripcion, tipoPasta, isbn,numEjemplares, portada, presentacion, precio);
			libro.setCategoria(categoriaDao.findOne(idCategoria));
			libro.setAutor(autorDao.findOne(idAutor));
			libroDao.add(libro);
		}else {
			Libro libro = new Libro(idLibro, titulo, editorial, numPaginas, edicion, idioma, fechaPublicacion
					, descripcion, tipoPasta, isbn,numEjemplares, portada, presentacion, precio);
			libro.setCategoria(categoriaDao.findOne(idCategoria));
			libro.setAutor(autorDao.findOne(idAutor));
			libroDao.up(libro);
		}
		return "redirect:/libros/findAll";
	}
	
	@GetMapping("/del")
	public String del(@RequestParam("idLibro") @Nullable Integer idLibro) {
		libroDao.del(idLibro);
		return "redirect:/libros/findAll";
	}

}
