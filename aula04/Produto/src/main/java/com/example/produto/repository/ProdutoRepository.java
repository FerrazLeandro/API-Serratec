package com.example.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.produto.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
