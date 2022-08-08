package com.uce.edu.demo.repository.libreria.repository;

import java.util.List;

import com.uce.edu.demo.repository.libreria.modelo.Proveedor;

public interface IProveedorRepository {
	
	public List<Proveedor> buscarProveedorInnerJoin (Integer cantidad);
	public List<Proveedor> buscarProveedorOuterJoinLeft(Integer cantidad);
	public List<Proveedor> buscarProveedorOuterJoinRight(Integer cantidad);
	

	public List<Proveedor> buscarProveedorJoinWhere(Integer cantidad);	
	public List<Proveedor> buscarProveedorJoinFetch(Integer cantidad);
	
}
