package com.distribuida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.*;


@Controller
@RequestMapping("facturacion")
public class FacturaController {

	@Autowired
	private ClienteDao clienteDao;
	
	@Autowired
	private LibroDao libroDao;
	
	@Autowired
	private FacturaDao facturaDao;
	
	@Autowired
	private FacturaDetalleDao facturaDetalleDao;
	
	@GetMapping("/principal")
	public String principal() {
		return "principal";
	}
	
	@GetMapping("/findAll")
	public String findAll(ModelMap modelMap) {
		modelMap.addAttribute("facturas", facturaDao.findAll());
		return "facturacion-listar";
	}
	
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idFactura") @Nullable Integer idFactura
			,@RequestParam("opcion") @Nullable Integer opcion
			,ModelMap modelMap) {
		
		modelMap.addAttribute("factura", facturaDao.findOne(idFactura));
		return "facturacion-listar";
	}
	
	@GetMapping("/findOneCliente")
	public String findOneCliente(@RequestParam("idCliente") @Nullable Integer idCliente
			,@RequestParam("opcion") @Nullable Integer opcion
			,ModelMap modelMap) {
		
		modelMap.addAttribute("cliente", clienteDao.findOne(idCliente));
		return "redirect:/facturacion/principal";
	}
}
