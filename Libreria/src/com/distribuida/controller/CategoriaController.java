package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.distribuida.dao.CategoriaDao;
import com.distribuida.entities.Categoria;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaDao categoriaDao;

	@GetMapping("/findAll") // path secundario
	public String findAll(Model model) {

		// try {
		List<Categoria> categorias = categoriaDao.findAll();
		model.addAttribute("categorias", categorias);
		return "categoria-listar"; // nombre del formulario web EJ: categoria-lista.jsp
		// }catch (Exception e) {
		// TODO: handle exception
		// }

	}
	
	@GetMapping("/findOne") // findOne se emple para actualizar o eleminar un registro
	public String findOne(@RequestParam("idCategoria") @Nullable Integer idCategoria,
			@RequestParam("opcion") @Nullable Integer opcion, Model model) {

		// try {
		if (idCategoria != null) {
			Categoria categoria = categoriaDao.findOne(idCategoria);
			model.addAttribute("categoria", categoria);
		}
		if (opcion == 1)
			return "categoria-add"; // redirige al formulario web "categoria-add"
		else
			return "categoria-del";

		// }catch (Exception e) {
		// TODO: handle exception
		// }

	}
	
	@PostMapping("/add")
	public String add(@RequestParam("idCategoria") @Nullable Integer idCategoria 
		,@RequestParam("categoria") @Nullable String categoria
		,@RequestParam("descripcion") @Nullable String descripcion
		, Model model
		) {
		if (idCategoria == null) {
			Categoria categoria1 = new Categoria (0,"nutella","peña");
			categoriaDao.add(categoria1);
		}else {
			Categoria categoria2 = new Categoria (idCategoria,categoria,descripcion);
			categoriaDao.up(categoria2);
		}
		return "redirect:/categorias/findAll";
	}
	
	@GetMapping("/del")
	public String del(@RequestParam("idCategoria") @Nullable Integer idCategoria) {
		//try {
			categoriaDao.del(idCategoria);
			return "redirect:/categorias/findAll";
		//}catch(Exception e) {}
		
	}

}
