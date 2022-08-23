package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

import com.uce.edu.demo.ProyectoU3AbApplication;
public class MainInterfacesFuncionales {
	
	private static Logger log = Logger.getLogger(ProyectoU3AbApplication.class);

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
	
		
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
		 
		
	//CONSUMER
		//CLases 
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");
		//Lambdas
		IPersonaConsumer<String> consumerLambda = cadena-> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		
		
	//PREDICATE
		//CLases 
		//Lambdas
		
		
	//FUNCTION
		//CLases 
		//Lambdas
		
		
		//UNARY OPERATOR (FUNCTION)
		//CLases 
		//Lambdas
		
	}

}
