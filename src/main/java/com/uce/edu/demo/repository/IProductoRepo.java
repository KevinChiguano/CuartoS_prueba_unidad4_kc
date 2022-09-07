package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoRepo {
	
	public void insertar(Producto producto);
	
	public Producto buscarCodigoBarra(String codigo);
	
	public void actualizar(Producto producto);
	
	public Producto conslutarStock(String codigo);
	

}
