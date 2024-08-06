package com.example.BeneVivere.Entity;

import com.example.BeneVivere.Entity.Usuarios;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "acessos")
public class Acessos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuarios usuario;

    @Column(name = "tp_acesso", nullable = false, length = 50)
    private String tipoAcesso;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_acesso", nullable = false)
    private Timestamp dataAcesso;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getTipoAcesso() {
        return tipoAcesso;
    }

    public void setTipoAcesso(String tipoAcesso) {
        this.tipoAcesso = tipoAcesso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Timestamp getDataAcesso() {
        return dataAcesso;
    }

    public void setDataAcesso(Timestamp dataAcesso) {
        this.dataAcesso = dataAcesso;
    }
}
