package com.uce.edu.demo.service.tfuncional;

public class EstudiantePredicateImpl implements IEstudiantePredicate<Integer> {
	@Override
	public Boolean evaluar(Integer arg1) {
		// TODO Auto-generated method stub
		boolean evalua = arg1>10;
		return evalua;
	}

}
