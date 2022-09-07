package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepo;
import com.uce.edu.demo.repository.IVentaRepo;
import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoVenta;
import com.uce.edu.demo.repository.modelo.Reporte;
import com.uce.edu.demo.repository.modelo.Venta;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private IProductoRepo productoRepo;
	
	@Autowired 
	private IVentaRepo ventaRepo;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void realizarVenta(List<ProductoVenta> productos, String cedula, String numeroVenta) {
		// TODO Auto-generated method stub
		
		Venta venta = new Venta();
		venta.setCedulaCliente(cedula);
		venta.setFecha(LocalDateTime.now());
		venta.setNumero(numeroVenta);
		
		List<DetalleVenta> detalles = new ArrayList<>();
		Integer cant = 0;
		BigDecimal total = new BigDecimal(0);

		for(ProductoVenta producto : productos) {
			Producto prod = new Producto();
			DetalleVenta detalleVenta = new DetalleVenta();
			
			prod = this.productoRepo.buscarCodigoBarra(producto.getCodigoBarra());
			
			cant = prod.getStock()-producto.getCantidad();
			
			if(prod.getStock() > 0) {
				if(cant >= 0) {
					prod.setStock(cant);
					detalleVenta.setCantidad(producto.getCantidad());
				}else {
					detalleVenta.setCantidad(prod.getStock());
					prod.setStock(0);	
				}
			}else {
				throw new RuntimeException();
			}
			
			
			detalleVenta.setPrecioUnitario(prod.getPrecio());
			detalleVenta.setProducto(prod);
			detalleVenta.setSubtotal(detalleVenta.getPrecioUnitario().multiply(new BigDecimal(detalleVenta.getCantidad())));
			detalleVenta.setProducto(prod);
			detalleVenta.setVenta(venta);
			
			total = total.add(detalleVenta.getSubtotal());
			
			detalles.add(detalleVenta);
			
			this.productoRepo.actualizar(prod);
		}
		
		venta.setDetalles(detalles);
		venta.setTotalVenta(total);
		
		
		this.ventaRepo.insertar(venta);
		
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public List<Reporte> buscarVentas(LocalDateTime fechaVenta, String categoria, Integer cantidad) {
		// TODO Auto-generated method stub
		return this.ventaRepo.buscarVentas(fechaVenta, categoria, cantidad);
	}

}
