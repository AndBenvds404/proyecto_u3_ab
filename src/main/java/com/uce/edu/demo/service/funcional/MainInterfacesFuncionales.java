package com.uce.edu.demo.service.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class MainInterfacesFuncionales {
	

		
	private static final Logger log = LoggerFactory.getLogger(MainInterfacesFuncionales.class);
	
	public static boolean prueba() {
		return true;
	}
	
	public static void imprimir(String cadena) {
		log.info(" "+cadena);
	}
	
	public static void guardar (String elemento) {
		log.info(""+elemento);
	}
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
	
		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();
		
	//SUPPLIER
		//CLases 
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		log.info("Supplier clase: "+ supplier.getNombre());
		
		IPersonaSupplier<String> supplierTE = new PersonaSupplierImpl();
		log.info("Supplier clase: "+ supplierTE.getNombre());
		
		//Lambdas
		IPersonaSupplier<String> supplierLambda = () -> "Franchesco2";
		log.info("Supplier lambda: "+ supplierLambda.getNombre());
		
		IPersonaSupplier<String> supplierLambdaTE = () -> "Franchesco TE2";
		log.info("Supplier lambda: "+ supplierLambdaTE.getNombre());
		 
		//Metodos high Order 
		String valorHO = metodosHO.consumirSupplier(()->{
			String valorConsultado = "1727";
			return valorConsultado;
			});
		log.info("HO supplier "+ valorHO);
		
		///JAVA
		log.info("JAVA supplier ");
		Stream<String> test = Stream.generate(()->"Andres 01").limit(7);
		test.forEach(cadena->System.out.println(cadena));
		
	//CONSUMER
		//CLases 
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");
		//Lambdas
		IPersonaConsumer<String> consumerLambda = cadena-> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		//metood High Order
		metodosHO.consumirConsumer(valor-> System.out.println(valor), 2);
		//JAVA
		log.info("JAVA Consumer ");
		List<Integer> listaNumero = Arrays.asList(1,2,3,4,5);
		listaNumero.forEach(numero-> System.out.println(numero));
		
		
		
		
	//PREDICATE
		//CLases 
		//Lambdas
		IPersonaPredicate<String> predicateLambda = cadena4 -> cadena4.contains("s");
		log.info("Predicate "+ predicateLambda.evaluar("Franchesco"));
		
		//metood High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("z"), "Franchesco");//comparamos la cadena que contenga z con "el string"
		log.info("HO Predicate:" + respuesta);
		
		//JAVA
		log.info("JAVA supplier "); 
		Stream <Integer> nuevaLista = listaNumero.stream().filter(numero-> prueba()); //-> cualquier cosa (true - guarda / false - no guarda)
		nuevaLista.forEach(numero->System.out.println(numero));
	
		
	//FUNCTION
		//CLases 
		//Lambdas
		IPersonaFunction<Integer, String> functionLambda = cadena -> { 
			Integer valor = Integer.parseInt(cadena);
			Integer valorfinal = valor -2;
			return  valorfinal;
		};
		log.info("Prdicate Lambdas: "+functionLambda.aplicar("7"));
		
		//metood High Order
		
		String valorfinalHO =metodosHO.consumirFunction(valor-> {
			//Aqui podemos colocar mucha logica de programacion
			String retorn  = valor.toString()+"A";
			return retorn;
		}, 1);
		log.info("HO function:"+ valorfinalHO );
		
		//JAVA
		log.info("JAVA function:");
		Stream<String>listaCambiada= listaNumero.stream().map(numerosListaf -> {
			Integer valor = numerosListaf +1;
			String cadena = "num: "+valor.toString();
			return cadena;
		});
		//listaCambiada.forEach(valorf->System.out.println(valorf));
		listaCambiada.forEach(valorf-> imprimir(valorf));
		
		
		
		
		
	//UNARY OPERATOR (FUNCTION)
		//CLases 
		//Lambdas
		
		IPersonaUnaryOperator<String> unaryLambda = cade ->{
			String valorFinal = cade.concat("sufijo");
			return valorFinal;
		};
		log.info("Prdicate Lambdas: "+unaryLambda.apply("Daniel"));
		
		
////////////////////////////////////////////////////////////////////		
		

		
		
		
	}

}

	


