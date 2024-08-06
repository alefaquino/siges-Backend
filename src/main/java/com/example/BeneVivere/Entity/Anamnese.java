package com.example.BeneVivere.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Anamnese {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Informações Pessoais
    private String nomePaciente;
    private LocalDate dataNascimento;
    private String sexo;
    private String estadoCivil;
    private String profissao;

    // Contato e Endereço
    private String telefone;
    private String email;
    private String endereco;

    // Histórico Médico
    @Column(length = 1000)
    private String doencasPrevias;

    @Column(length = 1000)
    private String cirurgias;

    @Column(length = 1000)
    private String alergias;

    @Column(length = 1000)
    private String medicamentosEmUso;

    @Column(length = 1000)
    private String historicoFamiliar;

    // Hábitos e Estilo de Vida
    private boolean fumante;
    private boolean alcool;
    private boolean drogasRecreativas;
    private String atividadeFisica;
    private String alimentacao;

    // Queixas e Sintomas
    private String queixaPrincipal;

    @ElementCollection
    private List<String> sintomas;

    private LocalDate inicioSintomas;

    // Histórico de Saúde Mental
    private boolean depressao;
    private boolean ansiedade;
    private String outrasCondicoesMentais;

    // Exame Físico
    private double peso;
    private double altura;
    private double imc;
    private double pressaoArterial;
    private double frequenciaCardiaca;

    // Exames Complementares
    @Column(length = 1000)
    private String examesLaboratoriais;

    @Column(length = 1000)
    private String examesImagem;

    @Column(length = 1000)
    private String outrosExames;

    // Diagnóstico e Plano de Tratamento
    @Column(length = 1000)
    private String diagnostico;

    @Column(length = 1000)
    private String planoTratamento;

    @ElementCollection
    private List<String> prescricoes;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDoencasPrevias() {
        return doencasPrevias;
    }

    public void setDoencasPrevias(String doencasPrevias) {
        this.doencasPrevias = doencasPrevias;
    }

    public String getCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(String cirurgias) {
        this.cirurgias = cirurgias;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getMedicamentosEmUso() {
        return medicamentosEmUso;
    }

    public void setMedicamentosEmUso(String medicamentosEmUso) {
        this.medicamentosEmUso = medicamentosEmUso;
    }

    public String getHistoricoFamiliar() {
        return historicoFamiliar;
    }

    public void setHistoricoFamiliar(String historicoFamiliar) {
        this.historicoFamiliar = historicoFamiliar;
    }

    public boolean isFumante() {
        return fumante;
    }

    public void setFumante(boolean fumante) {
        this.fumante = fumante;
    }

    public boolean isAlcool() {
        return alcool;
    }

    public void setAlcool(boolean alcool) {
        this.alcool = alcool;
    }

    public boolean isDrogasRecreativas() {
        return drogasRecreativas;
    }

    public void setDrogasRecreativas(boolean drogasRecreativas) {
        this.drogasRecreativas = drogasRecreativas;
    }

    public String getAtividadeFisica() {
        return atividadeFisica;
    }

    public void setAtividadeFisica(String atividadeFisica) {
        this.atividadeFisica = atividadeFisica;
    }

    public String getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(String alimentacao) {
        this.alimentacao = alimentacao;
    }

    public String getQueixaPrincipal() {
        return queixaPrincipal;
    }

    public void setQueixaPrincipal(String queixaPrincipal) {
        this.queixaPrincipal = queixaPrincipal;
    }

    public List<String> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<String> sintomas) {
        this.sintomas = sintomas;
    }

    public LocalDate getInicioSintomas() {
        return inicioSintomas;
    }

    public void setInicioSintomas(LocalDate inicioSintomas) {
        this.inicioSintomas = inicioSintomas;
    }

    public boolean isDepressao() {
        return depressao;
    }

    public void setDepressao(boolean depressao) {
        this.depressao = depressao;
    }

    public boolean isAnsiedade() {
        return ansiedade;
    }

    public void setAnsiedade(boolean ansiedade) {
        this.ansiedade = ansiedade;
    }

    public String getOutrasCondicoesMentais() {
        return outrasCondicoesMentais;
    }

    public void setOutrasCondicoesMentais(String outrasCondicoesMentais) {
        this.outrasCondicoesMentais = outrasCondicoesMentais;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(double pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public double getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public void setFrequenciaCardiaca(double frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public String getExamesLaboratoriais() {
        return examesLaboratoriais;
    }

    public void setExamesLaboratoriais(String examesLaboratoriais) {
        this.examesLaboratoriais = examesLaboratoriais;
    }

    public String getExamesImagem() {
        return examesImagem;
    }

    public void setExamesImagem(String examesImagem) {
        this.examesImagem = examesImagem;
    }

    public String getOutrosExames() {
        return outrosExames;
    }

    public void setOutrosExames(String outrosExames) {
        this.outrosExames = outrosExames;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPlanoTratamento() {
        return planoTratamento;
    }

    public void setPlanoTratamento(String planoTratamento) {
        this.planoTratamento = planoTratamento;
    }

    public List<String> getPrescricoes() {
        return prescricoes;
    }

    public void setPrescricoes(List<String> prescricoes) {
        this.prescricoes = prescricoes;
    }
}
