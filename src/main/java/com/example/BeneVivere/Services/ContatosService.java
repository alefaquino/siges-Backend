//package com.example.TesteNoxTec.Services;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//import java.util.Optional;
//
//import com.example.TesteNoxTec.Entity.Alunos;
//import com.example.TesteNoxTec.Repository.AlunosRepository;
//
//@Service
//public class ContatosService {
//
//    private final AlunosRepository alunosRepository;
//
//    @Autowired
//    public ContatosService(AlunosRepository alunosRepository) {
//        this.alunosRepository = alunosRepository;
//    }
//
//    public Alunos salvarContato(Alunos alunos) {
//        // Adicione lógica de validação, se necessário
//        return alunosRepository.save(alunos);
//    }
//
//    public List<Alunos> obterTodosContatos() {
//        return alunosRepository.findAll();
//    }
//
//    public Optional<Alunos> obterContatoPorId(Long id) {
//        return alunosRepository.findById(id);
//    }
//
//    public Optional<Alunos> obterContatoPorCelular(Long celular) {
//        return alunosRepository.findByCelular(celular);
//    }
//
//    public Alunos atualizarContato(Alunos alunos) {
//        // Adicione lógica de validação, se necessário
//        return alunosRepository.save(alunos);
//    }
//
//    public void excluirContato(Long id) {
//        alunosRepository.deleteById(id);
//    }
//
//    public void marcarComoFavorito(Long id, boolean isFavorito) {
//        Optional<Alunos> optionalContatos = alunosRepository.findById(id);
//
//        if (optionalContatos.isPresent()) {
//            Alunos alunos = optionalContatos.get();
//            alunos.setSnFavorito(isFavorito ? 'S' : 'N');
//            alunosRepository.save(alunos);
//        }
//    }
//}
