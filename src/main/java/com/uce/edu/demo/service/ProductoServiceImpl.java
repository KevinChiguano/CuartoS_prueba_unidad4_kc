package com.uce.edu.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepo;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private IProductoRepo productoRepo;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void ingresarProducto(Producto producto) {
		// TODO Auto-generated method stub
		
		try {
			Producto producto2 = this.productoRepo.buscarCodigoBarra(producto.getCodigoBarra());
			producto2.setStock(producto2.getStock()+producto.getStock());
			this.productoRepo.actualizar(producto2);
		} catch (Exception e) {
			this.productoRepo.insertar(producto);
		}
		
	}

	@Override
	public Producto conslutarStock(String codigo) {
		// TODO Auto-generated method stub
		return this.productoRepo.conslutarStock(codigo);
	}
	

}
