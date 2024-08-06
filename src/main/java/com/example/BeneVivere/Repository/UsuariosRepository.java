package com.example.BeneVivere.Repository;

import com.example.BeneVivere.Entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

}