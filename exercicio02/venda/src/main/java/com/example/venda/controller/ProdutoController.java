package com.example.venda.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.example.venda.domain.Produto;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	

	
	private static List<Produto> lista = new ArrayList<Produto>();
	static {
		lista.add(new Produto(1, "Mouse" , 10.60));
		lista.add(new Produto(2, "PC", 1500.));
	}
	
	@GetMapping
	public List<Produto> listar() {
		return lista;
	}
	
	@GetMapping("/{id}")
	public Produto buscar(@PathVariable Integer id) {
	// Usando função lambda
	return lista.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null); 
	
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto inserir(@RequestBody Produto Produto) {
		lista.add(Produto);
		return Produto;
	}
	

	@DeleteMapping("/{id}")
	public List<Produto> delete(@PathVariable Integer id) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId().equals(id)) {
				lista.remove(i);
				return listar();
			} 
		}
		return null;
	}
	
	
	@PutMapping("/{id}")
	public Produto atualizar(@RequestBody Produto Produto, @PathVariable Integer id) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId().equals(id)) {
				Produto a = new Produto(id, Produto.getNome(), Produto.getValor());
				lista.set(i,  a);
				return a;
			}
		}
		return null;
	}
}
