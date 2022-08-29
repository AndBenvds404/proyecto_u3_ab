package com.uce.edu.demo.service.tfuncional;

import java.math.BigDecimal;

public class ConsumoMetodosHighOrder {

	public String consumirSupplier (IEstudianteSupplier<Integer> funcion) {//recibimos una interfaz funcional
		
		/*String valor = funcion.getNombre();
		//Calcular/sumar consultar base, etc
		Integer numero = Integer.parseInt(valor);
		return numero;*/
		return funcion.getNumeroMaterias()+" Materias";
		
	}

	public void consumirConsumer (IEstudianteConsumer<Integer> funcion, Integer valor) {
		valor =valor*64;
		funcion.accept(valor);
	}
	
	public boolean consumirPredicate (IEstudiantePredicate<String> funcion, String valor) {
		return funcion.evaluar(valor);
	}
	
	public String consumirFunction (IEstudianteFunction<String, Double> funcion, Double valor) {
		
		valor =valor*(0.12); 
		return funcion.aplicar(valor);
		
	}
	
	public BigDecimal consumirUnaryOperator (IEstudianteFunction<BigDecimal, BigDecimal> funcion, BigDecimal monto) {
		

		return funcion.aplicar(monto);
		
	}
	
}
