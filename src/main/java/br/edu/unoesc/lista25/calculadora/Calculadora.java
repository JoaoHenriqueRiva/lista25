package br.edu.unoesc.lista25.calculadora;

public class Calculadora {

	public static double soma(Double n1, Double n2) {
		return n1 + n2;		
	}
	public static double subtracao(Double n1, Double n2) {
		return n1 - n2;
	}
	public static double multiplicacao(Double n1, Double n2) {
		return n1 * n2;
	}
	public static double divisao(Double n1, Double n2) {
		return n1 / n2;
	}
	public static double media(Double n1, Double n2) {
		return (n1 + n2) / 2;
	}
	public static double potencia(Double n1, Double n2) {
		return Math.pow(n1, n2);
	}
	public static double raiz2(Double n1) {
		return Math.sqrt(n1);
	}

}
