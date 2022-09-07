package com.uce.edu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.service.IGestorProducto;

@Controller
@RequestMapping("gestores")
public class GestorProductoController {
	
	@Autowired
	private IGestorProducto gestorProducto;
	
	@GetMapping("/buscarStock")
	public String vistaBuscarStock(Model model) {

		return "vistaProductoStock";
	}
	

}
