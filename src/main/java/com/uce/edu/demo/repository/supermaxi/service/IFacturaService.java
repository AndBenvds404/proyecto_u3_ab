package com.uce.edu.demo.repository.supermaxi.service;

import java.util.List;

public interface IFacturaService {
	
	public void compraProducto (String cedula, String numerofactura, List<String > codigoBarras);

}
