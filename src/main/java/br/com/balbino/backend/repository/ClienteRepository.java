package br.com.balbino.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.balbino.backend.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}