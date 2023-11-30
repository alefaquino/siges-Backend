package com.example.TesteNoxTec.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.TesteNoxTec.Entity.Contatos;

@Repository
public interface ContatosRepository extends JpaRepository<Contatos, Long> {
  


	Optional<Contatos> findByCelular(Long celular);
	
	
	
	
	

	void deleteById(Long id);
}