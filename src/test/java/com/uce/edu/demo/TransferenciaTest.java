package com.uce.edu.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootTest

class TransferenciaTest {

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;

	@Autowired
	private ITransferenciaService transferenciaService;

	@Autowired
	private ITransferenciaRepository transferenciaRepository;

	
	//1
	//Comprobar si se puede realizar una transferencia segun el saldo de una cuenta y el monto asignado
		@Test
		void montoTransferencia(){
			CuentaBancaria ctaOrigen = this.bancariaRepository.buscarPorNumero("54321");	
			BigDecimal monto = new BigDecimal(5);
			assertTrue(ctaOrigen.getSaldo().doubleValue() > monto.doubleValue(), "Comprobar Monto Válido");
		}

	//2
	//Comprobar validación de una transferencia
		@Test
		
		void insercion() {
			this.transferenciaService.realizarTransferencia("0001", "12345", "54321", new BigDecimal(4));
			Transferencia transferenciaDB = this.transferenciaRepository.buscarPorNumero("0001");

			CuentaBancaria ctaOrigen = this.bancariaRepository.buscarPorNumero("12345");	
			CuentaBancaria ctaDestino = this.bancariaRepository.buscarPorNumero("54321");	

			assertEquals(transferenciaDB.getCuentaOrigen().getNumero(), ctaOrigen.getNumero(),"Validar cuenta origen");
			assertEquals(transferenciaDB.getCuentaDestino().getNumero(), ctaDestino.getNumero(), "Validar cuenta destino");	
		}

		
		//
		@Test
		void insercionCuentasIguales() {
			CuentaBancaria ctaOrigen = this.bancariaRepository.buscarPorNumero("12345");	
			CuentaBancaria ctaDestino = this.bancariaRepository.buscarPorNumero("54321");	

			assertNotEquals(ctaOrigen.getNumero(), ctaDestino.getNumero(),"Validación misma cuenta");

			this.transferenciaService.realizarTransferencia("00002", "12345", "54321", new BigDecimal(5));		
		}

		
		//
		//Comprobar que se realizó la transferencia correctamente
		@Test
		void resultadoTransferencia() {
			CuentaBancaria ctaDestino = this.bancariaRepository.buscarPorNumero("54321");
			BigDecimal saldoDestino = ctaDestino.getSaldo();
			BigDecimal monto = new BigDecimal(5);
			this.transferenciaService.realizarTransferencia("00006", "12345", "54321", monto);
			BigDecimal saldoFinal = this.bancariaRepository.buscarPorNumero("54321").getSaldo();
			BigDecimal saldoEsperado = saldoDestino.add(monto);
			
			//assertTrue(saldoDestino.compareTo(saldoFinal.subtract(monto))==0, "Comprobar transferencia exitosa");
			assertTrue(saldoEsperado.compareTo(saldoFinal)==0, "Comprobar transferencia exitosa");

		}
}
