package com.example.BeneVivere.Repository;

import com.example.BeneVivere.Entity.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacientesRepository extends JpaRepository<Pacientes, Long> {
    // Método para encontrar um paciente pelo CPF
    Optional<Pacientes> findByCpf(String cpf);

    // Você pode adicionar outros métodos personalizados aqui, se necessário
}
