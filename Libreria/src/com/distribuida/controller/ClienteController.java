package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.ClienteDao;
import com.distribuida.entities.Cliente;


@Controller
@RequestMapping("/cliente") // path principal
public class ClienteController {

	@Autowired
	private ClienteDao clienteDao;

	@GetMapping("/findAll") // path secundario
	public String findAll(Model model) {

		// try {
		List<Cliente> clientes = clienteDao.findAll();
		model.addAttribute("clientes", clientes);
		return "cliente-listar"; // nombre del formulario web EJ: cliente-lista.jsp
		// }catch (Exception e) {
		// TODO: handle exception
		// }

	}

	@GetMapping("/findOne") // findOne se emple para actualizar o eleminar un registro
	public String findOne(@RequestParam("idcliente") @Nullable Integer idCliente,
			@RequestParam("opcion") @Nullable Integer opcion, Model model) {

		// try {
		if (idCliente != null) {
			Cliente cliente = clienteDao.findOne(idCliente);
			model.addAttribute("cliente", cliente);
		}
		if (opcion == 1)
			return "cliente-add"; // redirige al formulario web "cliente-add"
		else
			return "cliente-del";

		// }catch (Exception e) {
		// TODO: handle exception
		// }

	}
	
	@PostMapping("/add")
	public String add(@RequestParam("idCliente") @Nullable Integer idCliente 
		,@RequestParam("cedula") @Nullable String cedula
		,@RequestParam("nombre") @Nullable String nombre
		,@RequestParam("apellido") @Nullable String apellido
		,@RequestParam("direccion") @Nullable String direccion
		,@RequestParam("telefono") @Nullable String telefono
		,@RequestParam("correo") @Nullable String correo
		, Model model
		) {
		if (idCliente == null) {
			Cliente cliente = new Cliente(0,"1234567890","ni idea","lo que sea","donde sea","0987654321","quienseagmail.com");
			clienteDao.add(cliente);
		}else {
			Cliente cliente = new Cliente(idCliente,cedula,nombre,apellido,direccion,telefono,correo);
			clienteDao.up(cliente);
		}
		return "redirect:/clientes/findAll";
	}
	
	@GetMapping("/del")
	
	public String del(@RequestParam("idCliente") @Nullable Integer idCliente) {
		//try {
			clienteDao.del(idCliente);
			return "redirect:/clientes/findAll";
		//}catch(Exception e) {}
		
	}

}
