package com.uce.edu.demo.repository.supermaxi.repository;

import com.uce.edu.demo.repository.supermaxi.modelo.Cliente;

public interface IClienteRepository {
	
	public Cliente buscar (String cedula);

}
