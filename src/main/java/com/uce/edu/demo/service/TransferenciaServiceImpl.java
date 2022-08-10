package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;
@Service
public class TransferenciaServiceImpl  implements ITransferenciaService{

	@Autowired
	private ICuentaBancariaRepository iBancariaRepository;
	
	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	
	
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void realizarTransferencia(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		
		//busqueda de ct aorigen(obtner saldo)
		CuentaBancaria ctaOrigen = this.iBancariaRepository.buscarPorNumero(numeroCtaOrigen);
		//1. restar el monto  la cuenta origen
		BigDecimal saldoOrigen= ctaOrigen.getSaldo();
		BigDecimal saldoFinal = saldoOrigen.subtract(monto);
		ctaOrigen.setSaldo(saldoFinal);
		this.iBancariaRepository.actualizar(ctaOrigen);
		
		
		//0. busqeda de lacta Destino (obtener el saldo)
		CuentaBancaria ctaDestino = this.iBancariaRepository.buscarPorNumero(numeroCtaDestino);
		//2. Sumar el monto de la cta Destino
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.iBancariaRepository.actualizar(ctaDestino);
		//3. insertar transferencia
		Transferencia trans = new Transferencia();
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(monto);
		trans.setCuentaOrigen(ctaOrigen);
		trans.setCuentaDestino(ctaDestino);
		this.iTransferenciaRepository.insertar(trans);
		
		
		
	}
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferenciaFachada(String ctaOrigen, String ctaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		this.realizarTransferencia(ctaOrigen, ctaDestino, monto);
		
	}
	
}
