package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.ProductoSencillo;

public interface IGestorProducto {
	
	public ProductoSencillo consultarStock(String codigo);

}
