package com.uce.edu.demo.repository.supermaxi.service;

import java.math.BigDecimal;
import java.util.List;

public interface IFacturaService {
	
	public BigDecimal procesarFactura (String cedula, String numerofactura, List<String > codigoBarras);

}
