package com.example.BeneVivere.Controller;

import com.example.BeneVivere.Entity.Acessos;
import com.example.BeneVivere.Repository.AcessosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acessos")
public class AcessosController {

    @Autowired
    private AcessosRepository acessoRepository;

    @GetMapping
    public List<Acessos> getAllAcessos() {
        return acessoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Acessos> createAcesso(@RequestBody Acessos acesso) {
        Acessos savedAcesso = acessoRepository.save(acesso);
        return ResponseEntity.ok(savedAcesso);
    }

    // Outros métodos (PUT, DELETE) podem ser implementados conforme necessário
}
