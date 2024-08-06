package com.example.BeneVivere.Controller;

import com.example.BeneVivere.Entity.Produtos;
import com.example.BeneVivere.Services.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

    private final ProdutosService produtoService;

    @Autowired
    public ProdutosController(ProdutosService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produtos> listarTodos() {
        return produtoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtos> buscarPorId(@PathVariable Long id) {
        Optional<Produtos> produto = produtoService.buscarPorId(id);
        return produto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produtos adicionar(@RequestBody Produtos produtos) {
        return produtoService.adicionarProduto(produtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produtos> atualizar(@PathVariable Long id, @RequestBody Produtos produtoAtualizado) {
        try {
            Produtos produtos = produtoService.editarProduto(id, produtoAtualizado);
            return ResponseEntity.ok(produtos);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        produtoService.removerProdutos(id);
        return ResponseEntity.noContent().build();
    }
}

