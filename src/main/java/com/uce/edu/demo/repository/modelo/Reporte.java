package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;

public class Reporte {
	
	private String codigoBarra;
	private String nombre;
	private Integer cantidad;
	private BigDecimal precioUnitario;
	private BigDecimal subtotal;
	
	
	public Reporte() {

	}
	
	
	public Reporte(String codigoBarra, String nombre, Integer cantidad, BigDecimal precioUnitario,
			BigDecimal subtotal) {
		this.codigoBarra = codigoBarra;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.subtotal = subtotal;
	}

	
	

	@Override
	public String toString() {
		return "Reporte [codigoBarra=" + codigoBarra + ", nombre=" + nombre + ", cantidad=" + cantidad
				+ ", precioUnitario=" + precioUnitario + ", subtotal=" + subtotal + "]";
	}


	//GET y SET
	public String getCodigoBarra() {
		return codigoBarra;
	}


	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}


	public BigDecimal getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	
	
	
	
	

}
