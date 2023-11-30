
package com.example.TesteNoxTec.Entity;

import java.sql.Timestamp;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


import javax.persistence.Id;



@Entity
@Table(name = "coontato", schema = "desafio")


public class Contatos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
   
    @Column(name = "contatoId")
    private Long id;

    @Column(name = "contatoNome")
    private String nome;

    @Column(name = "contatoEmail")
    private String email;

    @Column(name = "contatoCelular")
    private Long celular;

    @Column(name = "contatoTelefone")
    private String telefone;

    @Column(name = "contatoSnFavorito")
    private char snFavorito;

    @Column(name = "contatoSnAtivo")
    private char snAtivo;

    @Column(name = "contatoDhCad")
    private Timestamp dhCadastro;

    // Construtores, getters e setters aqui

    public Contatos() {
    }

    public Contatos(String nome, String email, Long celular, String telefone, char snFavorito, char snAtivo, Timestamp dhCadastro) {
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.telefone = telefone;
        this.snFavorito = snFavorito;
        this.snAtivo = snAtivo;
        this.dhCadastro = dhCadastro;
    }

	public void setSnFavorito(char c) {
		// TODO Auto-generated method stub
		
	}

	public Long getCelular() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}

	public void setCelular(String numeroCelular) {
		// TODO Auto-generated method stub
		
	}

	
	

	
	
}