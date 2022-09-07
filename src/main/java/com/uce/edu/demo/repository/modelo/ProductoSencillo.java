package com.uce.edu.demo.repository.modelo;

public class ProductoSencillo {
	
	private String codigoBarra;
	private String categoria;
	private Integer stock;
	
	
	
	@Override
	public String toString() {
		return "ProductoSencillo [codigoBarra=" + codigoBarra + ", categoria=" + categoria + ", stock=" + stock + "]";
	}
	
	//SET y GET
	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	

}
