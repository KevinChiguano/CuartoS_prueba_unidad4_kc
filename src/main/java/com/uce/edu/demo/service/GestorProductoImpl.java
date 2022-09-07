package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepo;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;

@Service
public class GestorProductoImpl implements IGestorProducto {

	@Autowired
	private IProductoRepo productoRepo;
	
	@Override
	public ProductoSencillo consultarStock(String codigo) {
		// TODO Auto-generated method stub
		
		Producto producto = this.productoRepo.conslutarStock(codigo);
		ProductoSencillo productoSencillo = this.combiarObjetoSencillo(producto);
		
		return productoSencillo;
	}
	
	private ProductoSencillo combiarObjetoSencillo(Producto producto) {
		ProductoSencillo productoSencillo = new ProductoSencillo();
		productoSencillo.setCategoria(producto.getCategoria());
		productoSencillo.setCodigoBarra(producto.getCodigoBarra());
		productoSencillo.setStock(producto.getStock());
		
		return productoSencillo;
	}

}
