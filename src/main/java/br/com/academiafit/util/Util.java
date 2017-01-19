package br.com.academiafit.util;

import br.com.academiafit.exception.BusinessException;

public class Util {
	public static double calcularIMC(double altura, double peso) throws BusinessException{
		if (altura == 0 || peso == 0){
			throw new BusinessException("IMC não pode ser calculado."); 
		}else{
			return peso/(altura*altura);
		}
	}
}
