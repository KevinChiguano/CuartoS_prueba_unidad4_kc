package com.uce.edu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.service.IProductoService;

@Controller
@RequestMapping("productos")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	@PostMapping("/insertar")
	public String insertar(Producto producto) {
		this.productoService.ingresarProducto(producto);
		return "redirect:/productos/nuevoProducto";
	}
	
	@GetMapping("/nuevoProducto")
	public String paginaNuevaMateria(Producto producto) {
		return "vistaNuevoProducto";
	}
	

}
