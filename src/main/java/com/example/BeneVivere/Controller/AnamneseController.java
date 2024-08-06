package com.example.BeneVivere.Controller;

import com.example.BeneVivere.Entity.Anamnese;
import com.example.BeneVivere.Services.AnamneseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/anamneses")
public class AnamneseController {

    private final AnamneseService anamneseService;

    @Autowired
    public AnamneseController(AnamneseService anamneseService) {
        this.anamneseService = anamneseService;
    }

    @GetMapping
    public List<Anamnese> listarTodas() {
        return anamneseService.buscarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anamnese> buscarPorId(@PathVariable Long id) {
        Optional<Anamnese> anamnese = anamneseService.buscarPorId(id);
        return anamnese.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Anamnese adicionar(@RequestBody Anamnese anamnese) {
        return anamneseService.adicionarAnamnese(anamnese);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Anamnese> atualizar(@PathVariable Long id, @RequestBody Anamnese anamneseAtualizada) {
        try {
            Anamnese anamnese = anamneseService.editarAnamnese(id, anamneseAtualizada);
            return ResponseEntity.ok(anamnese);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        anamneseService.removerAnamnese(id);
        return ResponseEntity.noContent().build();
    }
}
