package br.com.balbino.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import br.com.balbino.backend.model.Pedido;
import br.com.balbino.backend.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository repository;

    public PedidoController(PedidoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return repository.save(pedido);
    }

    @GetMapping
    public List<Pedido> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> buscarPorId(@PathVariable Long id) {
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}