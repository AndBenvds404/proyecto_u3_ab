package com.uce.edu.demo.repository.supermaxi.service;

import java.math.BigDecimal;

import com.uce.edu.demo.repository.supermaxi.modelo.Factura;
import com.uce.edu.demo.repository.supermaxi.modelo.FacturaElectronica;

public interface IFacturaElectronicaService {

	public void insertar(FacturaElectronica facturaElectronica);
	public void crearFacturaSRI(Factura factura);
	public void procesarElectronica(String numero, Integer cantidadItems, BigDecimal monto);
}
