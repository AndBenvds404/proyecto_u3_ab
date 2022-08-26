package com.uce.edu.demo.repository.supermaxi.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorComprasServiceImpl implements IGestorComprasService {
	
	@Autowired
	private IFacturaService iFacturaService;
	@Autowired
	private IFacturaElectronicaService iFacturaElectronicaService;
	
	
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void registrarCompraProducto(String cedula, String numeroFactura, List<String> codigoBarras) {
		// TODO Auto-generated method stub
		
		BigDecimal totalPagar = this.iFacturaService.procesarFactura(cedula, numeroFactura, codigoBarras);
		
		this.iFacturaElectronicaService.procesarElectronica(numeroFactura, codigoBarras.size(), totalPagar);
	}
	
	

}
