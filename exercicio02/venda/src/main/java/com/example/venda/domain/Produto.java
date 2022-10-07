package com.example.venda.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="valor")
	private Double valor;
	
	public Integer getId() {
		return id;
	}

	public Produto(Integer id, String nome, Double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}

	public Produto() {
		
	}

	public String getNome() {
		return nome;
	}

	public Double getValor() {
		return valor;
	}
	
	
	
}
