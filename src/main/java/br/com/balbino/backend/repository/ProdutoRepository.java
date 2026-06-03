package br.com.balbino.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.balbino.backend.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}