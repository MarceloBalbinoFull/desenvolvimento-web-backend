package br.com.balbino.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import br.com.balbino.backend.model.Cliente;
import br.com.balbino.backend.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @GetMapping
    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> buscarPorId(@PathVariable Long id) {
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}