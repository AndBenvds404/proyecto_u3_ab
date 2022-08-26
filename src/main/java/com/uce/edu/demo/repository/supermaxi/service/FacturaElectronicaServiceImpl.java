package com.uce.edu.demo.repository.supermaxi.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.supermaxi.modelo.DetalleFactura;
import com.uce.edu.demo.repository.supermaxi.modelo.Factura;
import com.uce.edu.demo.repository.supermaxi.modelo.FacturaElectronica;
import com.uce.edu.demo.repository.supermaxi.repository.IFacturaElectronicaRepository;
@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService{
	
	@Autowired
	private IFacturaElectronicaRepository iFacturaElectronicaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void insertar(FacturaElectronica facturaElectronica) {
		// TODO Auto-generated method stub
	
	}
	


	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void procesarElectronica(String numeroFactura, Integer cantidadItems, BigDecimal monto) {
		// TODO Auto-generated method stub
		FacturaElectronica facturaElectronica = new FacturaElectronica();
		facturaElectronica.setNumero(numeroFactura);
		facturaElectronica.setFechaCreacion(LocalDateTime.now());
		facturaElectronica.setNumeroDetalles(cantidadItems);
		facturaElectronica.setMonto(monto);
		this.iFacturaElectronicaRepository.insertar(facturaElectronica);
		throw new RuntimeException();

	}



	@Override
	public void crearFacturaSRI(Factura factura) {
		// TODO Auto-generated method stub
		
	}
	
	

}
