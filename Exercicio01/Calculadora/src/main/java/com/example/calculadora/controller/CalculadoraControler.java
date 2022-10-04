package com.example.calculadora.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora/api/v1")
public class CalculadoraControler {

	
	//@GetMapping
	//Obs: @RequestMapping, por padrão, responde às chamadas do verbo/método GET
	// para acessar os metodos deve usar a url passando parâmetros http://localhost:8080/calculadora/api/v1/somar?numero1=1&numero2=2
	
	@RequestMapping("/somar")
	public String somar(@RequestParam Integer numero1, Integer numero2) {
		Integer soma;
		
		soma = numero1 + numero2;
		
		return "O resultado da soma de " + numero1 + " e " + numero2 + " é: " + soma;

	}
	
	@RequestMapping("/subtrair")
	public String subtrair(@RequestParam Integer numero1, Integer numero2) {
		Integer subtracao;
		
		subtracao = numero1 - numero2;
		
		return "O resultado da subtração de " + numero1 + " e " + numero2 + " é: " + subtracao;

	}
	
	@RequestMapping("/dividir")
	public String dividir(@RequestParam Integer numero1, Integer numero2) {
		Integer divisao;
		
		divisao = numero1 / numero2;
		
		return "O resultado da divisao de " + numero1 + " por " + numero2 + " é: " + divisao;

	}
	
	@RequestMapping("/multiplicar")
	public String multiplicar(@RequestParam Integer numero1, Integer numero2) {
		Integer multiplicacao;
		
		multiplicacao = numero1 * numero2;
		
		return "O resultado da multiplicacao de " + numero1 + " por " + numero2 + " é: " + multiplicacao;

	}
}
