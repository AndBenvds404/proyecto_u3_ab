package com.uce.edu.demo.repository.libreria.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.libreria.modelo.Proveedor;
import com.uce.edu.demo.repository.modelo.Hotel;
@Repository
@Transactional
public class ProveedorRepositoryImpl implements IProveedorRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Proveedor> buscarProveedorInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Proveedor> myQuery = this.entityManager.createQuery("SELECT p FROM Proveedor p JOIN p.productos pr WHERE pr.cantidad =: datoCantidad",Proveedor.class); // h.la relacion mapeada del modelo
		myQuery.setParameter("datoCantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Proveedor> buscarProveedorOuterJoinLeft(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Proveedor> myQuery = this.entityManager.createQuery("SELECT p FROM Proveedor p LEFT JOIN p.productos pr WHERE pr.cantidad =: datoCantidad",Proveedor.class); // h.la relacion mapeada del modelo
		myQuery.setParameter("datoCantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Proveedor> buscarProveedorOuterJoinRight(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Proveedor> myQuery = this.entityManager.createQuery("SELECT p FROM Proveedor p RIGHT JOIN p.productos pr WHERE pr.cantidad =: datoCantidad",Proveedor.class); // h.la relacion mapeada del modelo
		myQuery.setParameter("datoCantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Proveedor> buscarProveedorJoinWhere(Integer cantidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proveedor> buscarProveedorJoinFetch(Integer cantidad) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
