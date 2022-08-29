package com.uce.edu.demo.service.tfuncional;

public class EstudianteConsumerImpl implements IEstudianteConsumer<String>{
	
	@Override
	public void accept(String arg1) {
		// TODO Auto-generated method stub
		String arg= arg1.concat(" Benavides");
		System.out.println(arg+" concatenado");
	}
	
	
	
}
