package com.example.BeneVivere.Services;

import com.example.BeneVivere.Entity.Anamnese;
import com.example.BeneVivere.Repository.AnamneseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnamneseService {

    private final AnamneseRepository anamneseRepository;

    @Autowired
    public AnamneseService(AnamneseRepository anamneseRepository) {
        this.anamneseRepository = anamneseRepository;
    }

    // Buscar todas as anamneses
    public List<Anamnese> buscarTodas() {
        return anamneseRepository.findAll();
    }

    // Buscar anamnese por ID
    public Optional<Anamnese> buscarPorId(Long id) {
        return anamneseRepository.findById(id);
    }

    // Adicionar nova anamnese
    public Anamnese adicionarAnamnese(Anamnese anamnese) {
        return anamneseRepository.save(anamnese);
    }

    // Editar anamnese existente
    public Anamnese editarAnamnese(Long id, Anamnese anamneseAtualizada) {
        return anamneseRepository.findById(id)
                .map(anamnese -> {
                    // Atualize os atributos conforme necessário
                    anamnese.setNomePaciente(anamneseAtualizada.getNomePaciente());
                    anamnese.setDataNascimento(anamneseAtualizada.getDataNascimento());
                    anamnese.setSexo(anamneseAtualizada.getSexo());
                    anamnese.setEstadoCivil(anamneseAtualizada.getEstadoCivil());
                    anamnese.setProfissao(anamneseAtualizada.getProfissao());
                    anamnese.setTelefone(anamneseAtualizada.getTelefone());
                    anamnese.setEmail(anamneseAtualizada.getEmail());
                    anamnese.setEndereco(anamneseAtualizada.getEndereco());
                    anamnese.setDoencasPrevias(anamneseAtualizada.getDoencasPrevias());
                    anamnese.setCirurgias(anamneseAtualizada.getCirurgias());
                    anamnese.setAlergias(anamneseAtualizada.getAlergias());
                    anamnese.setMedicamentosEmUso(anamneseAtualizada.getMedicamentosEmUso());
                    anamnese.setHistoricoFamiliar(anamneseAtualizada.getHistoricoFamiliar());
                    anamnese.setFumante(anamneseAtualizada.isFumante());
                    anamnese.setAlcool(anamneseAtualizada.isAlcool());
                    anamnese.setDrogasRecreativas(anamneseAtualizada.isDrogasRecreativas());
                    anamnese.setAtividadeFisica(anamneseAtualizada.getAtividadeFisica());
                    anamnese.setAlimentacao(anamneseAtualizada.getAlimentacao());
                    anamnese.setQueixaPrincipal(anamneseAtualizada.getQueixaPrincipal());
                    anamnese.setSintomas(anamneseAtualizada.getSintomas());
                    anamnese.setInicioSintomas(anamneseAtualizada.getInicioSintomas());
                    anamnese.setDepressao(anamneseAtualizada.isDepressao());
                    anamnese.setAnsiedade(anamneseAtualizada.isAnsiedade());
                    anamnese.setOutrasCondicoesMentais(anamneseAtualizada.getOutrasCondicoesMentais());
                    anamnese.setPeso(anamneseAtualizada.getPeso());
                    anamnese.setAltura(anamneseAtualizada.getAltura());
                    anamnese.setImc(anamneseAtualizada.getImc());
                    anamnese.setPressaoArterial(anamneseAtualizada.getPressaoArterial());
                    anamnese.setFrequenciaCardiaca(anamneseAtualizada.getFrequenciaCardiaca());
                    anamnese.setExamesLaboratoriais(anamneseAtualizada.getExamesLaboratoriais());
                    anamnese.setExamesImagem(anamneseAtualizada.getExamesImagem());
                    anamnese.setOutrosExames(anamneseAtualizada.getOutrosExames());
                    anamnese.setDiagnostico(anamneseAtualizada.getDiagnostico());
                    anamnese.setPlanoTratamento(anamneseAtualizada.getPlanoTratamento());
                    anamnese.setPrescricoes(anamneseAtualizada.getPrescricoes());
                    return anamneseRepository.save(anamnese);
                })
                .orElseThrow(() -> new RuntimeException("Anamnese não encontrada"));
    }

    // Remover anamnese por ID
    public void removerAnamnese(Long id) {
        anamneseRepository.deleteById(id);
    }
}
