package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Reporte;
import com.uce.edu.demo.repository.modelo.Venta;

@Repository
@Transactional
public class VentaRepoImpl implements IVentaRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Venta venta) {
		// TODO Auto-generated method stub
		this.entityManager.persist(venta);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Reporte> buscarVentas(LocalDateTime fechaVenta, String categoria, Integer cantidad) {
		// TODO Auto-generated method stub
		
		TypedQuery<Reporte> myQuery = this.entityManager.createNamedQuery("Venta.buscarVentas", Reporte.class);
		myQuery.setParameter("fecha", fechaVenta);
		myQuery.setParameter("categoria", categoria);
		myQuery.setParameter("cantidad", cantidad);
		
		return myQuery.getResultList();
	}

}
