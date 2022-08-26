package com.uce.edu.demo.repository.supermaxi.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.supermaxi.modelo.Cliente;
import com.uce.edu.demo.repository.supermaxi.modelo.DetalleFactura;
import com.uce.edu.demo.repository.supermaxi.modelo.Factura;
import com.uce.edu.demo.repository.supermaxi.modelo.Producto;
import com.uce.edu.demo.repository.supermaxi.repository.IClienteRepository;
import com.uce.edu.demo.repository.supermaxi.repository.IFacturaRepository;
import com.uce.edu.demo.repository.supermaxi.repository.IProductoRepository;
@Service
public class FacturaServiceImpl implements IFacturaService {
	
	
	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Autowired
	private IFacturaRepository iFacturaRepository;
	
	@Autowired
	private IClienteRepository iClienteRepository;
	
	
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public BigDecimal procesarFactura(String cedula, String numerofactura, List<String> codigoBarras) {
		// TODO Auto-generated method stub
		BigDecimal totalPagar = BigDecimal.ZERO;
		Cliente cliente = this.iClienteRepository.buscar(cedula);
				
		Factura fact = new Factura();
		fact.setCliente(cliente);
		fact.setFecha(LocalDateTime.now());
		fact.setNumero(numerofactura);
		
		this.iFacturaRepository.insertar(fact);
		
		List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
		
		for (String codigoProducto : codigoBarras) {
			
			DetalleFactura detalle = new DetalleFactura();
			detalle.setCantidad(1);  //siempre la cantidad será 1
			detalle.setFactura(fact);
			Producto producto = this.iProductoRepository.buscarCodigoBarras(codigoProducto);
			detalle.setProducto(producto);
			detalle.setSubtotal(detalle.getProducto().getPrecio());
			totalPagar.add(detalle.getSubtotal());
			producto.setStock(producto.getStock()-detalle.getCantidad());
			this.iProductoRepository.actualizar(producto);
			detalles.add(detalle);
		}
		fact.setDetallers(detalles);
		this.iFacturaRepository.insertar(fact);
		return totalPagar;
			
	
	}

}
