package br.edu.unoesc.lista25.controller;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.lista25.ConversorNumerico.ConversorNumerico;
import br.edu.unoesc.lista25.calculadora.Calculadora;

@RestController
@RequestMapping("/api/calc")
public class CalcController {
	private Logger logger = Logger.getLogger(CalcController.class.getName());
	
	@GetMapping("/somar-query")
    public Double somarQuery(@RequestParam(value = "numero1", defaultValue = "0") Double numero1, @RequestParam(value = "numero2", defaultValue = "0") Double numero2) {
		logger.info("Calculando... " + numero1 + " + " + numero2);
		return Calculadora.soma(numero1, numero2);
    }
    @RequestMapping(value = "/somar-path/{numero1}/{numero2}", method = RequestMethod.GET)
    public Double somarPath(@PathVariable("numero1") String numero1, @PathVariable(value = "numero2") String numero2) {
    	logger.info("Calculando... " + numero1 + " + " + numero2);
    	if (!ConversorNumerico.ehNumerico(numero1) || !ConversorNumerico.ehNumerico(numero2)) {
    		return 0d;
    	}
    	return Calculadora.soma(ConversorNumerico.converterParaDouble(numero1), ConversorNumerico.converterParaDouble(numero2));
    }
    @GetMapping("/sub-query")
    public Double subQuery(@RequestParam(value = "n1", defaultValue = "0") Double n1, @RequestParam(value = "n2", defaultValue = "0") Double n2) {
    	logger.info("Calculando..." + n1 + "-" + n2);
    	return Calculadora.subtracao(n1, n2);
    }
    @RequestMapping(value = "/sub-path/{n1}/{n2}", method = RequestMethod.GET)
    public Double subPath(@PathVariable("n1") String n1, @PathVariable(value = "n2") String n2) {
    	logger.info("Calculando..." + n1 + "-" + n2);
    	if(!ConversorNumerico.ehNumerico(n1) || !ConversorNumerico.ehNumerico(n2)) {
    		return 0d;
    	}
    	return Calculadora.subtracao(ConversorNumerico.converterParaDouble(n1), ConversorNumerico.converterParaDouble(n2));
    }
    @GetMapping("/mult-query")
    public Double multQuery(@RequestParam(value = "n1", defaultValue = "0") Double n1, @RequestParam(value = "n2", defaultValue = "0") Double n2) {
    	logger.info("Calculando... " + n1 + " * " + n2);
    	return Calculadora.multiplicacao(n1, n2);
    }
    @RequestMapping(value = "/mult-path/{n1}/{n2}")
    public Double multPath(@PathVariable("n1") String n1, @PathVariable(value = "n2") String n2) {
    	logger.info("Calculando... " + n1 + " * " + n2);
    	if (!ConversorNumerico.ehNumerico(n1) || !ConversorNumerico.ehNumerico(n2)) {
    		return 0d;
    	}
    	return Calculadora.multiplicacao(ConversorNumerico.converterParaDouble(n1), ConversorNumerico.converterParaDouble(n2));
    }
    @GetMapping("/div-query")
    public Double divQuery(@RequestParam(value = "n1", defaultValue = "0") Double n1, @RequestParam(value = "n2", defaultValue = "0") Double n2) {
    	logger.info("Calculando..." + n1 + "/" + n2);
    	return Calculadora.divisao(n1, n2);
    }
    @RequestMapping(value = "/div-path/{n1}/{n2}", method = RequestMethod.GET)
    public Double divPath(@PathVariable("n1") String n1, @PathVariable(value = "n2") String n2) {
    	logger.info("Calculando..." + n1 + "/" + n2);
    	if(!ConversorNumerico.ehNumerico(n1) || !ConversorNumerico.ehNumerico(n2)) {
    		return 0d;
    	}
    	return Calculadora.divisao(ConversorNumerico.converterParaDouble(n1), ConversorNumerico.converterParaDouble(n2));
    }
    @GetMapping("/media-query")
    public Double mediaQuery(@RequestParam(value = "n1", defaultValue = "0") Double n1, @RequestParam(value = "n2", defaultValue = "0") Double n2) {
    	logger.info("Calculando a media entre " + n1 + " e " + n2);
    	return Calculadora.media(n1, n2);
    }
    @RequestMapping(value = "/media-path/{n1}/{n2}", method = RequestMethod.GET)
    public Double mediaPath(@PathVariable("n1") String n1, @PathVariable(value = "n2") String n2) {
    	logger.info("Calculando a media entre " + n1 + " e " + n2);
    	if(!ConversorNumerico.ehNumerico(n1) || !ConversorNumerico.ehNumerico(n2)) {
    		return 0d;
    	}
    	return Calculadora.media(ConversorNumerico.converterParaDouble(n1), ConversorNumerico.converterParaDouble(n2));
    }
    @GetMapping("/pow-query")
    public Double powQuery(@RequestParam(value = "n1", defaultValue = "0") Double n1, @RequestParam(value = "n2", defaultValue = "0") Double n2) {
    	logger.info("Calculando..." + n1 + "^" + n2);
    	return Calculadora.potencia(n1, n2);
    }
    @RequestMapping(value = "/pow-path/{n1}/{n2}", method = RequestMethod.GET)
    public Double powPath(@PathVariable("n1") String n1, @PathVariable(value = "n2") String n2) {
    	logger.info("Calculando..." + n1 + "^" + n2);
    	if(!ConversorNumerico.ehNumerico(n1) || !ConversorNumerico.ehNumerico(n2)) {
    		return 0d;
    	}
    	return Calculadora.potencia(ConversorNumerico.converterParaDouble(n1), ConversorNumerico.converterParaDouble(n2));
    }
    @GetMapping("/rad-query")
    public Double radQuery(@RequestParam(value = "n", defaultValue = "0") Double n){
    	logger.info("Calculando a raiz quadrada de " + n);
    	try {
    		if (n < 1){
    			throw new ArithmeticException("Valor de *n* não poder ser menor que 1");
    		}
    		return Calculadora.raiz2(n);
    	} catch (ArithmeticException e){
    		logger.info("ERRO: " + e);
    		return 0d;	
    	}
    }
    @RequestMapping(value = "/rad-path/{n}", method = RequestMethod.GET)
    public Double radPath(@PathVariable("n") String n) {
    	logger.info("Calculando a raiz quadrada de " + n);
    	if(!ConversorNumerico.ehNumerico(n)) {
    		return 0d;
    	}
    	try {
    		if (ConversorNumerico.converterParaDouble(n) < 1){
    			throw new ArithmeticException("Valor de *n* não poder ser menor que 1");
    		}
    		return Calculadora.raiz2(ConversorNumerico.converterParaDouble(n));
    	}catch (ArithmeticException e){
    		logger.info("ERRO: " + e);
    		return 0d;
    	}
    }
}
