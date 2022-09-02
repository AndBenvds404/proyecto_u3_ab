package com.uce.edu.demo.hilos.tparalelo;

import java.util.Arrays;

public class MainParaleloTarea35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  long to = System.currentTimeMillis();

		  	System.out.println("Nombre del Hilo "+Thread.currentThread().getName());
	       
		  	PaginaWebParalelo servicio1 = new PaginaWebParalelo("entretenimiento",Arrays.asList(1001,1002,1003));
		  	PaginaWebParalelo servicio2 = new PaginaWebParalelo("buscador",Arrays.asList(1004,1005));
		  	PaginaWebParalelo servicio3 = new PaginaWebParalelo("correo electronico",Arrays.asList(1010,1011,1012, 1013,1014));
		  	
		  	PaginaWebParalelo servicio4 = new PaginaWebParalelo("foros",Arrays.asList(1015,1016,1017,1018));
		  	PaginaWebParalelo servicio5 = new PaginaWebParalelo("mensajeria",Arrays.asList(1021,1022));

		  	
	        ServidorParalelo gestorAtencion  = new ServidorParalelo(servicio1); 
	        gestorAtencion.start(); 
	        ServidorParalelo gestorAtencion2  = new ServidorParalelo(servicio2);
	        gestorAtencion2.start();
	        ServidorParalelo gestorAtencion3  = new ServidorParalelo(servicio3);
	        gestorAtencion3.start();

	        ServidorParalelo gestorAtencion4  = new ServidorParalelo(servicio4); 
	        gestorAtencion4.start(); 
	        ServidorParalelo gestorAtencion5  = new ServidorParalelo(servicio5);
	        gestorAtencion5.start();
	        
	        long tf = System.currentTimeMillis();
	        long dt = (tf-to)/1000;
	        System.out.println("Tiempo: " + dt+"seg");

	}

}
