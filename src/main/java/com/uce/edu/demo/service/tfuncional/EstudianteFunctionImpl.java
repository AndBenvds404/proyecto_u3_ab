package com.uce.edu.demo.service.tfuncional;

public class EstudianteFunctionImpl implements IEstudianteFunction<Boolean, Integer>{
	
	@Override
	public Boolean aplicar(Integer arg1) {
		// TODO Auto-generated method stub
		Boolean arg = arg1.equals(0);
		
		return arg;
	}
	
	

}
