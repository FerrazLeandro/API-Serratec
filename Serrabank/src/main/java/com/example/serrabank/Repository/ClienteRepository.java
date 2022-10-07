package com.example.serrabank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.serrabank.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
