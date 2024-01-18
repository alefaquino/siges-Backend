//*//package com.example.TesteNoxTec.Controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.TesteNoxTec.Entity.Alunos;
//import com.example.TesteNoxTec.Services.ContatosService;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/contatos")
//public class ContatosController {
//
//
//	private ContatosService contatosService;
//
//    @Autowired
//    public ContatosController(ContatosService contatosService) {
//
//		this.contatosService = contatosService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Alunos> cadastrarContatos(@RequestBody Alunos alunos) {
//        // Validar se o contato já foi cadastrado através do número do celular
//        Optional<Alunos> existingContato = contatosService.obterContatoPorCelular(alunos.getCelular());
//        if (existingContato.isPresent()) {
//            return ResponseEntity.badRequest().body(null); // Pode ajustar o retorno conforme necessário
//        }
//
//        Alunos novoContato = contatosService.salvarContato(alunos);
//        return ResponseEntity.ok(novoContato);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Alunos>> consultarContatos() {
//        List<Alunos> contatoes = contatosService.obterTodosContatos();
//        return ResponseEntity.ok(contatoes);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Alunos> consultarContatoPorId(@PathVariable Long id) {
//        Optional<Alunos> contatos = contatosService.obterContatoPorId(id);
//        return contatos.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Alunos> atualizarContato(@PathVariable Long id, @RequestBody Alunos alunos) {
//        if (!contatosService.obterContatoPorId(id).isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        alunos.setId(id);
//        Alunos contatoAtualizado = contatosService.atualizarContato(alunos);
//        return ResponseEntity.ok(contatoAtualizado);
//    }
//
//    @PatchMapping("/{id}/inativar")
//    public ResponseEntity<Void> inativarContato(@PathVariable Long id) {
//        if (!contatosService.obterContatoPorId(id).isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        contatosService.excluirContato(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PatchMapping("/{id}/favorito")
//    public ResponseEntity<Void> marcarComoFavorito(@PathVariable Long id, @RequestParam boolean isFavorito) {
//        if (!contatosService.obterContatoPorId(id).isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        contatosService.marcarComoFavorito(id, isFavorito);
//        return ResponseEntity.noContent().build();
//    }
//}
