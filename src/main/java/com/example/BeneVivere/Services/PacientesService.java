package com.example.BeneVivere.Services;


import com.example.BeneVivere.Entity.Pacientes;
import com.example.BeneVivere.Entity.Usuarios;
import com.example.BeneVivere.Repository.PacientesRepository;
import com.example.BeneVivere.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacientesService {

    @Autowired
    private PacientesRepository pacienteRepository;

    @Autowired
    private UsuariosRepository usuarioRepository;

    // Método para criar um novo paciente e vinculá-lo a um usuário
    public Pacientes criarPaciente(Pacientes novoPaciente, Long usuarioId) throws Exception {
        // Busca o usuário pelo ID
        Optional<Usuarios> usuarioOptional = usuarioRepository.findById(usuarioId);

        if (usuarioOptional.isPresent()) {
            // Se o usuário for encontrado, vincula o paciente ao usuário
            Usuarios usuario = usuarioOptional.get();
            novoPaciente.setUsuario(usuario);

            // Salva o paciente no banco de dados
            return pacienteRepository.save(novoPaciente);
        } else {
            throw new Exception("Usuário não encontrado.");
        }
    }

    // Método para buscar um paciente por ID
    public Optional<Pacientes> buscarPacientePorId(Long id) {
        return pacienteRepository.findById(id);
    }

    // Método para buscar todos os pacientes
    public List<Pacientes> buscarTodosPacientes() {
        return pacienteRepository.findAll();
    }

    // Método para atualizar um paciente existente
    public Pacientes atualizarPaciente(Long id, Pacientes pacienteAtualizado) throws Exception {
        Optional<Pacientes> pacienteOptional = pacienteRepository.findById(id);

        if (pacienteOptional.isPresent()) {
            Pacientes pacienteExistente = pacienteOptional.get();

            // Atualiza os dados do paciente
            pacienteExistente.setNome(pacienteAtualizado.getNome());
            pacienteExistente.setCpf(pacienteAtualizado.getCpf());
            pacienteExistente.setTelefone(pacienteAtualizado.getTelefone());
            pacienteExistente.setEmail(pacienteAtualizado.getEmail());
            pacienteExistente.setEndereco(pacienteAtualizado.getEndereco());
            pacienteExistente.setDataNascimento(pacienteAtualizado.getDataNascimento());
            pacienteExistente.setSexo(pacienteAtualizado.getSexo());
            pacienteExistente.setEstadoCivil(pacienteAtualizado.getEstadoCivil());
            pacienteExistente.setProfissao(pacienteAtualizado.getProfissao());
            pacienteExistente.setContatoEmergenciaNome(pacienteAtualizado.getContatoEmergenciaNome());
            pacienteExistente.setContatoEmergenciaTelefone(pacienteAtualizado.getContatoEmergenciaTelefone());
            pacienteExistente.setAnamnese(pacienteAtualizado.getAnamnese());

            // Salva as alterações
            return pacienteRepository.save(pacienteExistente);
        } else {
            throw new Exception("Paciente não encontrado.");
        }
    }

    // Método para deletar um paciente pelo ID
    public void deletarPaciente(Long id) throws Exception {
        Optional<Pacientes> pacienteOptional = pacienteRepository.findById(id);

        if (pacienteOptional.isPresent()) {
            pacienteRepository.deleteById(id);
        } else {
            throw new Exception("Paciente não encontrado.");
        }
    }
}
