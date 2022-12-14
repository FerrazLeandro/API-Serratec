package com.example.veiculo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.veiculo.domain.Veiculo;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	@Value("${nomeCliente}")
	private String nomeCliente;
	
	@GetMapping("/cliente")
	public String retornaCliente() {
		return nomeCliente;
	}
	
	private static List<Veiculo> lista = new ArrayList<Veiculo>();
	static {
		lista.add(new Veiculo(1234L, "VW", "Gol"));
		lista.add(new Veiculo(0000L, "Fiat", "Palio"));
		lista.add(new Veiculo(2222L, "Renault", "Logan Claiver"));
	}
	
	@GetMapping
	public List<Veiculo> listar() {
		return lista;
	}
	
	@GetMapping("/{id}")
	public Veiculo buscar(@PathVariable Long id) {
	// Usando função lambda
	return lista.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null); 
	
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo inserir(@RequestBody Veiculo veiculo) {
		lista.add(veiculo);
		return veiculo;
	}
	

	@DeleteMapping("/{id}")
	public List<Veiculo> delete(@PathVariable Long id) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId().equals(id)) {
				lista.remove(i);
				return listar();
			} 
		}
		return null;
	}
	
	
	@PutMapping("/{id}")
	public Veiculo atualizar(@RequestBody Veiculo veiculo, @PathVariable Long id) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId().equals(id)) {
				Veiculo a = new Veiculo(id, veiculo.getMarca(), veiculo.getModelo());
				lista.set(i,  a);
				return a;
			}
		}
		return null;
	}
	
}
