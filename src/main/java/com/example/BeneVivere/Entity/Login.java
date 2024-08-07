package com.example.BeneVivere.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Login {


    @OneToOne
    private Usuarios usuario;
    private Usuarios email;
    private Usuarios senha;


    public Login(Usuarios email, Usuarios senha, Usuarios usuario) {
        this.email = email;
        this.senha = senha;
        this.usuario = usuario;
    }
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Usuarios getEmail() {
        return email;
    }

    public void setEmail(Usuarios email) {
        this.email = email;
    }

    public Usuarios getSenha() {
        return senha;
    }

    public void setSenha(Usuarios senha) {
        this.senha = senha;
    }
}
