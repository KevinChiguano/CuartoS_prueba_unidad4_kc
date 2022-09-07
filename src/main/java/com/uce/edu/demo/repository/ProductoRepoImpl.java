package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Producto;

@Repository
@Transactional
public class ProductoRepoImpl implements IProductoRepo {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);

	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscarCodigoBarra(String codigo) {
		// TODO Auto-generated method stub
		
		TypedQuery<Producto> myQuery = this.entityManager.createQuery("select p from Producto p where p.codigoBarra =:codigo", Producto.class);
		myQuery.setParameter("codigo", codigo);
		
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto conslutarStock(String codigo) {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Producto> criteriaQuery = builder.createQuery(Producto.class);
		Root<Producto> tabla = criteriaQuery.from(Producto.class);
		Predicate predicateCodigo = builder.equal(tabla.get("codigoBarra"), codigo);
		
		criteriaQuery.select(tabla).where(predicateCodigo);
		
		TypedQuery<Producto> myQuery = this.entityManager.createQuery(criteriaQuery);
		
		return myQuery.getSingleResult();
	}

}
