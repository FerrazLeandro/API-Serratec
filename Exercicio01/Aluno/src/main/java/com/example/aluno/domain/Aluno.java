package com.example.aluno.domain;

public class Aluno {
	private Long matricula;
	private String nome;
	private String telefone;
	
	public Aluno(Long matricula, String nome, String telefone) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.telefone = telefone;	
	}
	
	public Aluno() {}
	
	public Long getMatricula() {
		return matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	

}
