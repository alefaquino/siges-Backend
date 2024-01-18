
package com.example.TesteNoxTec.Entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


import javax.persistence.Id;



@Entity
@Table(name = "alunos", schema = "escola")


public class Alunos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
   
    @Column(name = "id")
    private Long id;

    @Column(name = "nomeAluno")
    private String nome;

    @Column(name = "nomeResponsavel")
    private String nomeResponsavel;

    @Column(name = "dataNascimento")
    private Date dataNascimento;

    @Column(name = "serie")
    private String serie;

    @Column(name = "dataPagamento")
    private Date dataPagamento;

    @Column(name = "cpfResponsavel")
    private String cpfResponsavel;

    @Column(name = "telefone")
    private String telefone;
    @Column(name = "endereco")
    private String endereco;

    @Column(name = "cep")
    private String cep;

    @Column(name = "identidadeAluno")
    private String identidadeAluno;

    @Column(name = "horario")
    private String horario;

    @Column(name = "valorMensalidade")
    private String valorMensalidade;


    // Construtores, getters e setters aqui

    public Alunos() {
    }

    public Alunos(String nome, String nomeResponsavel, Date dataNascimento, Date dataPagamento, String serie, String cpfResponsavel, String cep, String horario,String identidadeAluno,String endereco, String valorMensalidade) {
        this.nome = nome;
        this.nomeResponsavel = nomeResponsavel;
        this.dataNascimento = dataNascimento;
        this.dataPagamento = dataPagamento;
        this.serie = serie;
        this.cpfResponsavel = cpfResponsavel;
        this.cep = cep;
        this.horario = horario;
        this.identidadeAluno = identidadeAluno;
        this.endereco = endereco;
        this.valorMensalidade = valorMensalidade;
    }


	

	
	
}