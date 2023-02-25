package br.edu.unoesc.lista25.ConversorNumerico;

import java.util.logging.Logger;

import br.edu.unoesc.lista25.controller.CalcController;

public class ConversorNumerico {

	private static Logger logger = Logger.getLogger(CalcController.class.getName()); 
	public static boolean ehNumerico(String strNumero) {
		if (strNumero == null) {
			logger.info("Valor ausente!");
			return false;
		}
		String numero = strNumero.replaceAll(",", ".");
		try {
			System.out.println(Double.parseDouble(numero));
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
		public static Double converterParaDouble(String strNumero) {
			if (strNumero == null) {
				return 0d;
			}
			
			String numero = strNumero.replaceAll(",", ".");
			if (ehNumerico(numero)) {
				return Double.parseDouble(numero);
			}
			
			return 0d;
		}
}
