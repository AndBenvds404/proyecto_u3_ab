package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

import com.uce.edu.demo.hilos.tradicional.Cajero;
import com.uce.edu.demo.hilos.tradicional.PcCajero;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  long to = System.currentTimeMillis();

		  	System.out.println("Nombre del Hilo "+Thread.currentThread().getName()); //obtenemos el nombre del hilo
	       
		  	CajeroParalelo c1 = new CajeroParalelo("Maty",Arrays.asList("lulu"));
		  	CajeroParalelo c2 = new CajeroParalelo("Roberto",Arrays.asList("pepe"));
		  	CajeroParalelo c3 = new CajeroParalelo("Gorgorio",Arrays.asList("añañin"));
		  	
		  	CajeroParalelo c4 = new CajeroParalelo("Maty",Arrays.asList("fiufiu"));
		  	CajeroParalelo c5 = new CajeroParalelo("Roberto",Arrays.asList("amon"));
		  	CajeroParalelo c6 = new CajeroParalelo("Gorgorio",Arrays.asList("añañin"));

		  	
	        PCCajeroParalelo gestorAtencion  = new PCCajeroParalelo(c1); //los argumentos deben ser enviados por el contructor
	        gestorAtencion.start(); //procesar
	        PCCajeroParalelo gestorAtencion2  = new PCCajeroParalelo(c2);
	        gestorAtencion2.start();
	        PCCajeroParalelo gestorAtencion3  = new PCCajeroParalelo(c3);
	        gestorAtencion3.start();

	        PCCajeroParalelo gestorAtencion4  = new PCCajeroParalelo(c4); //los argumentos deben ser enviados por el contructor
	        gestorAtencion4.start(); //procesar
	        PCCajeroParalelo gestorAtencion5  = new PCCajeroParalelo(c5);
	        gestorAtencion5.start();
	        PCCajeroParalelo gestorAtencion6  = new PCCajeroParalelo(c6);
	        gestorAtencion6.start();
	        
	        long tf = System.currentTimeMillis();
	        long dt = (tf-to)/1000;
	        System.out.println("Tiempo: " + dt+"seg");

	}

}
