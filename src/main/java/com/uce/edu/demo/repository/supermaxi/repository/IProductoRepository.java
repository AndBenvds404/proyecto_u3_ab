package com.uce.edu.demo.repository.supermaxi.repository;

import com.uce.edu.demo.repository.supermaxi.modelo.Producto;

public interface IProductoRepository {
	
	public void actualizar (Producto p);
	public Producto buscarCodigoBarras (String codigoBarras);

}
