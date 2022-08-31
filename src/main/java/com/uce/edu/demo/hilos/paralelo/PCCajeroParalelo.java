package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

import com.uce.edu.demo.hilos.tradicional.Cajero;

public class PCCajeroParalelo extends Thread{
	private CajeroParalelo cajeroParalelo;
	
	public PCCajeroParalelo(CajeroParalelo cajeroParalelo) {
		// TODO Auto-generated constructor stub
		this.cajeroParalelo= cajeroParalelo;
	}
	
	//siempre q se extienda de Thread se debe 
	//sobreescribir el metodo run, dispara el metodo paralelizar
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.procesar(this.cajeroParalelo);
	}
	
	public void procesar(CajeroParalelo cajeroParalelo) {
		  long to = System.currentTimeMillis();
		System.out.println("Nombre de hilo Processar"+ Thread.currentThread().getName());
		System.out.println("procesando cajero"+ cajeroParalelo);
		for (String cliente: cajeroParalelo.getClientes()) {
			this.atenderCliente(cliente);
		}
	     long tf = System.currentTimeMillis();
	      long dt = (tf-to)/1000;
		System.out.println("termino: "+ cajeroParalelo.getNomre()+ "en: "+ dt);
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
