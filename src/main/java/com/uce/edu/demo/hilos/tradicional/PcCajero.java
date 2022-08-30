package com.uce.edu.demo.hilos.tradicional;

import java.util.concurrent.TimeUnit;

public class PcCajero {
	
	public void procesar(Cajero cajero) {
		System.out.println("procesando cajero"+ cajero);
		for (String cliente: cajero.getClientes()) {
			this.atenderCliente(cliente);
		}
	}
	
	
	private void atenderCliente(String cliente) {
        System.out.println("Atendiendo a:"+ cliente);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}