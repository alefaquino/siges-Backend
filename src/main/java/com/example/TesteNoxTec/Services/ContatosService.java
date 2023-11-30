package com.example.TesteNoxTec.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.TesteNoxTec.Entity.Contatos;
import com.example.TesteNoxTec.Repository.ContatosRepository;

@Service
public class ContatosService {

    private final ContatosRepository contatosRepository ;

    @Autowired
    public ContatosService(ContatosRepository contatosRepository) {
        this.contatosRepository = contatosRepository;
    }

    public Contatos salvarContato(Contatos contatos) {
        // Adicione lógica de validação, se necessário
        return contatosRepository.save(contatos);
    }

    public List<Contatos> obterTodosContatos() {
        return contatosRepository.findAll();
    }

    public Optional<Contatos> obterContatoPorId(Long id) {
        return contatosRepository.findById(id);
    }

    public Optional<Contatos> obterContatoPorCelular(Long celular) {
        return contatosRepository.findByCelular(celular);
    }

    public Contatos atualizarContato(Contatos contatos) {
        // Adicione lógica de validação, se necessário
        return contatosRepository.save(contatos);
    }

    public void excluirContato(Long id) {
        contatosRepository.deleteById(id);
    }

    public void marcarComoFavorito(Long id, boolean isFavorito) {
        Optional<Contatos> optionalContatos = contatosRepository.findById(id);

        if (optionalContatos.isPresent()) {
            Contatos contatos = optionalContatos.get();
            contatos.setSnFavorito(isFavorito ? 'S' : 'N');
            contatosRepository.save(contatos);
        }
    }
}
