package com.example.TesteNoxTec.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TesteNoxTec.Entity.Contatos;
import com.example.TesteNoxTec.Services.ContatosService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contatos")
public class ContatosController {

   
	private ContatosService contatosService;

    @Autowired
    public ContatosController(ContatosService contatosService) {
       
		this.contatosService = contatosService;
    }

    @PostMapping
    public ResponseEntity<Contatos> cadastrarContatos(@RequestBody Contatos contatos) {
        // Validar se o contato já foi cadastrado através do número do celular
        Optional<Contatos> existingContato = contatosService.obterContatoPorCelular(contatos.getCelular());
        if (existingContato.isPresent()) {
            return ResponseEntity.badRequest().body(null); // Pode ajustar o retorno conforme necessário
        }

        Contatos novoContato = contatosService.salvarContato(contatos);
        return ResponseEntity.ok(novoContato);
    }

    @GetMapping
    public ResponseEntity<List<Contatos>> consultarContatos() {
        List<Contatos> contatos = contatosService.obterTodosContatos();
        return ResponseEntity.ok(contatos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contatos> consultarContatoPorId(@PathVariable Long id) {
        Optional<Contatos> contatos = contatosService.obterContatoPorId(id);
        return contatos.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contatos> atualizarContato(@PathVariable Long id, @RequestBody Contatos contatos) {
        if (!contatosService.obterContatoPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        contatos.setId(id);
        Contatos contatoAtualizado = contatosService.atualizarContato(contatos);
        return ResponseEntity.ok(contatoAtualizado);
    }

    @PatchMapping("/{id}/inativar")
    public ResponseEntity<Void> inativarContato(@PathVariable Long id) {
        if (!contatosService.obterContatoPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        contatosService.excluirContato(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/favorito")
    public ResponseEntity<Void> marcarComoFavorito(@PathVariable Long id, @RequestParam boolean isFavorito) {
        if (!contatosService.obterContatoPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        contatosService.marcarComoFavorito(id, isFavorito);
        return ResponseEntity.noContent().build();
    }
}
