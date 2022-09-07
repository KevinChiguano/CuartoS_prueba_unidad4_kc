package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.ProductoVenta;
import com.uce.edu.demo.repository.modelo.Reporte;

public interface IVentaService {
	
	public void realizarVenta(List<ProductoVenta> productos, String cedula, String numeroVenta);
	
	public List<Reporte> buscarVentas(LocalDateTime fechaVenta, String categoria, Integer cantidad);

}
