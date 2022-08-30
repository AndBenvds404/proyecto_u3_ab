package com.uce.edu.demo.service.tfuncional;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionalesTarea33 {
	

		
	private static final Logger log = LoggerFactory.getLogger(MainInterfacesFuncionalesTarea33.class);

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
	
		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();
		
	//SUPPLIER
		//CLases 
		log.info("Supplier");
		IEstudianteSupplier<Integer> supplier = new EstudianteSupplierImpl();
		log.info("Clase: Numero de materias: "+ supplier.getNumeroMaterias());

		//Lambdas
		IEstudianteSupplier<Integer> supplierLambda = () -> 8;
		log.info("Lambda: Numero de materias: "+ supplierLambda.getNumeroMaterias());
		
		//Metodos high Order 
		String valorHO = metodosHO.consumirSupplier(()->{
			Integer valorConsultado = 6;
			return valorConsultado;
			});
		log.info("HO supplier "+ valorHO);
		
		
		
	//CONSUMER
		//CLases 
		log.info("Consumer");
		IEstudianteConsumer<String> consumerClase = new EstudianteConsumerImpl();
		consumerClase.accept("Clase: Andres");
		//Lambdas
		IEstudianteConsumer<Integer> consumerLambda = cadena-> System.out.println(cadena+" dato procesado");
		consumerLambda.accept(1727094851);
		
		//metood High Order
		metodosHO.consumirConsumer(valor-> System.out.println("valor procesado: "+valor), 12);
		
		
		
	//PREDICATE
		log.info("Predicate");
		//CLases 
		IEstudiantePredicate<Integer> predicateClase = new EstudiantePredicateImpl();
		log.info("Clase: Numero mayor a 10: "+ predicateClase.evaluar(10));
		//Lambdas
		IEstudiantePredicate<String> predicateLambda = cadena4 -> cadena4.startsWith("A");
		log.info("Predicate: La cadena empieza con A: "+ predicateLambda.evaluar("Andres"));
		//metood High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.endsWith("s"), "Andres");//comparamos la cadena que contenga z con "el string"
		log.info("High Order: La cadena termina con s: " + respuesta);
		
	
		
	//FUNCTION
		log.info("Fuction");
		//CLases 
		IEstudianteFunction<Boolean, Integer> functionClase= new EstudianteFunctionImpl();
		log.info("Clase: numero de materias es distinto de 0: "+ functionClase.aplicar(15));
		
		//Lambdas
		IEstudianteFunction<Boolean, Integer> functionLambda = cadena -> { 
			String valor = String.valueOf(cadena);
			Boolean evalua = valor.contains("1");
			return  evalua;
		};
		Integer numeros = 1234;
		log.info("Lambdas: "+numeros+" contiene el numero 1 materia de primer semestre: "+functionLambda.aplicar(numeros));
		
		//metood High Order
		String valorfinalHO =metodosHO.consumirFunction(valor-> {
			//Aqui podemos colocar mucha logica de programacion
			String retorn  = valor.toString()+" Valor matricula";
			return retorn;
		}, 430.0);
		log.info("High Order: " + valorfinalHO );
	
		
	//UNARY OPERATOR (FUNCTION)
		//CLases 
		IEstudianteUnaryOperator<String> unaryOperatorClase = new EstudianteUnaryOperatorImpl();
		log.info("Clase: Asignar cargo "+ unaryOperatorClase.apply("Sebastian"));
		//Lambdas
		
		IEstudianteUnaryOperator<Double> unaryLambda = creditos ->{
			Double ingreso =  (creditos*(0.18*60/365));
			Double montoFinal = ingreso+creditos;
			return montoFinal;
		};
		log.info("Lambdas: Valor por credito: "+unaryLambda.apply(6.50));
		
		//metood High Order
		
		BigDecimal horasClase = metodosHO.consumirUnaryOperator(monto-> {
			Integer anios= 5;
			BigDecimal calculo =  new BigDecimal(1).subtract(new BigDecimal(2).divide(new BigDecimal(100)));
			BigDecimal totalFinal =monto.add( monto.multiply(calculo.pow(anios)));
			return totalFinal;
		}, new BigDecimal(300));
		
		log.info("High Order: Horas clase semestre: " +horasClase);
		
	}

}

	


