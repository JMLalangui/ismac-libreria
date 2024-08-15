package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.distribuida.dao.*;
import com.distribuida.entities.*;

@Controller
@RequestMapping("/autor") 
public class AutorController {
	
	@Autowired
	private AutorDao autorDao;
	
	@GetMapping("/findAll") // path secundario
	public String findAll(Model model) {

		// try {
		List<Autor> autores = autorDao.findAll();
		model.addAttribute("autores", autores);
		return "autor-listar"; // nombre del formulario web EJ: cliente-lista.jsp
		// }catch (Exception e) {
		// TODO: handle exception
		// }

	}
	
	@GetMapping("/findOne") // findOne se emple para actualizar o eleminar un registro
	public String findOne(@RequestParam("idAutor") @Nullable Integer idAutor,
			@RequestParam("opcion") @Nullable Integer opcion, Model model) {

		// try {
		if (idAutor != null) {
			Autor autor = autorDao.findOne(idAutor);
			model.addAttribute("autor", autor);
		}
		if (opcion == 1)
			return "autor-add"; // redirige al formulario web "cliente-add"
		else
			return "autor-del";

		// }catch (Exception e) {
		// TODO: handle exception
		// }

	}
	
	@PostMapping("/add")
	public String add(@RequestParam("idAutor") @Nullable Integer idAutor 
		,@RequestParam("nombre") @Nullable String nombre
		,@RequestParam("apellido") @Nullable String apellido
		,@RequestParam("pais") @Nullable String pais
		,@RequestParam("direccion") @Nullable String direccion
		,@RequestParam("telefono") @Nullable String telefono
		,@RequestParam("correo") @Nullable String correo
		, Model model
		) {
		if (idAutor == null) {
			Autor autor = new Autor(0,"nutella","peña","ecuador","ascazubi","0987654321","nutella@gmail.com");
			autorDao.add(autor);
		}else {
			Autor autor = new Autor(idAutor,nombre,apellido,pais,direccion,telefono,correo);
			autorDao.up(autor);
		}
		return "redirect:/autores/findAll";
	}
	
	@GetMapping("/del")
	public String del(@RequestParam("idAutor") @Nullable Integer idAutor) {
		//try {
			autorDao.del(idAutor);
			return "redirect:/autores/findAll";
		//}catch(Exception e) {}
		
	}
	
	
	

}
