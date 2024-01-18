package com.example.TesteNoxTec.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TesteNoxTec.Entity.Alunos;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos, Long> {

}