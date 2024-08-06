package com.example.BeneVivere.Repository;

import com.example.BeneVivere.Entity.Anamnese;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnamneseRepository extends JpaRepository<Anamnese, Long> {
    // Métodos personalizados de consulta podem ser adicionados aqui, se necessário
}
