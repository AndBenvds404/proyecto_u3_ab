package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  long to = System.currentTimeMillis();

	        Cajero c1 = new Cajero("Bena",Arrays.asList("lulu","ana","juan"));
	        Cajero c2 = new Cajero("Yisus",Arrays.asList("pepe","roberto","amon"));
	        Cajero c3 = new Cajero("Guana",Arrays.asList("añañin","taylor","chavo"));

	        PcCajero gestorAtencion  = new PcCajero();
	        gestorAtencion.procesar(c1);
	        gestorAtencion.procesar(c2);
	        gestorAtencion.procesar(c3);

	        long tf = System.currentTimeMillis();
	        long dt = (tf-to)/1000;
	        System.out.println("Tiempo: " + dt+"seg");

	
	}

}
