package com.uce.edu.demo.repository.supermaxi.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.supermaxi.modelo.Cliente;
import com.uce.edu.demo.repository.supermaxi.modelo.DetalleFactura;
import com.uce.edu.demo.repository.supermaxi.modelo.Factura;
import com.uce.edu.demo.repository.supermaxi.modelo.Producto;
import com.uce.edu.demo.repository.supermaxi.repository.IClienteRepository;
import com.uce.edu.demo.repository.supermaxi.repository.IDetalleFacturaRepository;
import com.uce.edu.demo.repository.supermaxi.repository.IFacturaRepository;
import com.uce.edu.demo.repository.supermaxi.repository.IProductoRepository;
@Service
public class FacturaServiceImpl implements IFacturaService {
	
	Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Autowired
	private IFacturaRepository iFacturaRepository;
	
	@Autowired
	private IClienteRepository iClienteRepository;
	
	@Autowired
	private IDetalleFacturaRepository iDetalleFacturaRepository;
	
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void compraProducto(String cedula, String numerofactura, List<String> codigoBarras) {
		// TODO Auto-generated method stub
		
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
			
			producto.setStock(producto.getStock()-1);
			
			if (producto.getStock()>0) {
				
				detalle.setSubtotal(producto.getPrecio());//ojo
				detalles.add(detalle);
				
				this.iDetalleFacturaRepository.insertar(detalle);
				this.iProductoRepository.actualizar(producto);
				
			}else {
				LOG.error("Stock insuficiente: "+ producto.getNombre());
			}
				
		}
		fact.setDetallers(detalles);
	}

}
