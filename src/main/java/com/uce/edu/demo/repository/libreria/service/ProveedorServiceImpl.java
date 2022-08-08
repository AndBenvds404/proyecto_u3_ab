package com.uce.edu.demo.repository.libreria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.libreria.modelo.Proveedor;
import com.uce.edu.demo.repository.libreria.repository.IProveedorRepository;

@Service
public class ProveedorServiceImpl implements IProveedorService{

	@Autowired
	private IProveedorRepository iProveedorRepository;

	@Override
	public List<Proveedor> buscarProveedorInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.iProveedorRepository.buscarProveedorInnerJoin(cantidad) ;
	}

	@Override
	public List<Proveedor> buscarProveedorOuterJoinLeft(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.iProveedorRepository.buscarProveedorOuterJoinLeft(cantidad);
	}

	@Override
	public List<Proveedor> buscarProveedorOuterJoinRight(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.iProveedorRepository.buscarProveedorOuterJoinRight(cantidad);
	}

	@Override
	public List<Proveedor> buscarProveedorJoinWhere(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.iProveedorRepository.buscarProveedorJoinWhere(cantidad);
	}

	@Override
	public List<Proveedor> buscarProveedorJoinFetch(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.iProveedorRepository.buscarProveedorJoinFetch(cantidad);
	}
	


}
