package com.example.BeneVivere.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigoProduto;

    @Column(nullable = false)
    private LocalDate dataFabricacao;

    @Column(nullable = false)
    private LocalDate dataValidade;

    @Column(nullable = false)
    private double preco;

    @Column(nullable = false)
    private String tipoProduto;

    @Column(nullable = false)
    private String componentePrincipal;

    @Column(nullable = false)
    private String componenteSecundario;

    private String marca;
    private double peso;
    private String unidadeMedida;
    private String fabricante;

    // Construtor padrão
    public Produtos() {}

    // Construtor completo
    public Produtos(String codigoProduto, LocalDate dataFabricacao, LocalDate dataValidade,
                   double preco, String tipoProduto, String componentePrincipal, String componenteSecundario,
                   String marca, double peso, String unidadeMedida, String fabricante) {
        this.codigoProduto = codigoProduto;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.preco = preco;
        this.tipoProduto = tipoProduto;
        this.componentePrincipal = componentePrincipal;
        this.componenteSecundario = componenteSecundario;
        this.marca = marca;
        this.peso = peso;
        this.unidadeMedida = unidadeMedida;
        this.fabricante = fabricante;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getComponentePrincipal() {
        return componentePrincipal;
    }

    public void setComponentePrincipal(String componentePrincipal) {
        this.componentePrincipal = componentePrincipal;
    }

    public String getComponenteSecundario() {
        return componenteSecundario;
    }

    public void setComponenteSecundario(String componenteSecundario) {
        this.componenteSecundario = componenteSecundario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    // Método toString() para fácil visualização
    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", codigoProduto='" + codigoProduto + '\'' +
                ", dataFabricacao=" + dataFabricacao +
                ", dataValidade=" + dataValidade +
                ", preco=" + preco +
                ", tipoProduto='" + tipoProduto + '\'' +
                ", componentePrincipal='" + componentePrincipal + '\'' +
                ", componenteSecundario='" + componenteSecundario + '\'' +
                ", marca='" + marca + '\'' +
                ", peso=" + peso +
                ", unidadeMedida='" + unidadeMedida + '\'' +
                ", fabricante='" + fabricante + '\'' +
                '}';
    }
}
