package com.example.produto.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_produto")
	private Long id;
	
	@Column(name="descricao", nullable = false, length = 40)
	private String descricao;
	
	@Column(name="valor", nullable = false)
	private Double valor;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name="data_cadastro", nullable = false)
	private LocalDate dataCadastro;
	
	
	
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public Long getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
	
}
