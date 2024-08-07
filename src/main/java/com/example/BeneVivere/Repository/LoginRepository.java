package com.example.BeneVivere.Repository;

import com.example.BeneVivere.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    // Você pode adicionar métodos personalizados aqui, se necessário
}
