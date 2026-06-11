package br.com.balbino.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import br.com.balbino.backend.model.Produto;
import br.com.balbino.backend.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @GetMapping
    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscarPorId(@PathVariable Long id) {
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id,
                             @RequestBody Produto produtoAtualizado) {

        Produto produto = repository.findById(id).orElseThrow();

        produto.setNome(produtoAtualizado.getNome());
        produto.setValor(produtoAtualizado.getValor());

        return repository.save(produto);
    }
}