package com.example.BeneVivere.Controller;


import com.example.BeneVivere.Entity.Pacientes;
import com.example.BeneVivere.Entity.Usuarios;
import com.example.BeneVivere.Repository.PacientesRepository;
import com.example.BeneVivere.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {

    @Autowired
    private PacientesRepository pacienteRepository;

    @Autowired
    private UsuariosRepository usuarioRepository;

    // Endpoint para criar um novo paciente e vinculá-lo a um usuário
    @PostMapping("/criar")
    public ResponseEntity<String> criarPaciente(@RequestBody Pacientes novoPaciente, @RequestParam Long usuarioId) {
        // Busca o usuário pelo ID
        Optional<Usuarios> usuarioOptional = usuarioRepository.findById(usuarioId);

        if (usuarioOptional.isPresent()) {
            // Se o usuário for encontrado, vincula o paciente ao usuário
            Usuarios usuario = usuarioOptional.get();
            novoPaciente.setUsuario(usuario);

            // Salva o paciente no banco de dados
            pacienteRepository.save(novoPaciente);

            return ResponseEntity.ok("Paciente criado e vinculado ao usuário com sucesso.");
        } else {
            // Se o usuário não for encontrado, retorna uma resposta de erro
            return ResponseEntity.badRequest().body("Usuário não encontrado.");
        }
    }

    // Endpoint para buscar um paciente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pacientes> buscarPacientePorId(@PathVariable Long id) {
        Optional<Pacientes> pacienteOptional = pacienteRepository.findById(id);

        return pacienteOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Outros métodos como atualizar, deletar, etc., podem ser adicionados conforme necessário
}
