package com.example.BeneVivere.Repository;

import com.example.BeneVivere.Entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
    // Métodos de consulta personalizados podem ser adicionados aqui
}
