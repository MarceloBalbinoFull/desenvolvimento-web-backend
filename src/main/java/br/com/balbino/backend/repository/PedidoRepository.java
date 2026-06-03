package br.com.balbino.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.balbino.backend.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}