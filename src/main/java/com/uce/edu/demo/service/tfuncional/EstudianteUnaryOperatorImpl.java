package com.uce.edu.demo.service.tfuncional;

public class EstudianteUnaryOperatorImpl implements IEstudianteUnaryOperator<String> {
	
	@Override
	public String apply(String arg1) {
		// TODO Auto-generated method stub
		arg1.concat(" Empleado");
		return arg1;
	}

}
