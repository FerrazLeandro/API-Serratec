package com.example.olamundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OlaMundo {
	
	@GetMapping("/ola")
	public String olaMundo () {
		return "Olá mundo!";
	}
	
	
	@RequestMapping("/resposta")
	public String resposta () {
		return "Oi Leandro";
	}
}
