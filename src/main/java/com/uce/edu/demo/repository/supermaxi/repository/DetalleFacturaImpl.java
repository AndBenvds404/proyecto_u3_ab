package com.uce.edu.demo.repository.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.supermaxi.modelo.DetalleFactura;

@Repository
@Transactional
public class DetalleFacturaImpl implements IDetalleFacturaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(DetalleFactura detalle) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalle);
	}
	
	
	

}
