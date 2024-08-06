package com.example.BeneVivere.Services;

import com.example.BeneVivere.Entity.Produtos;
import com.example.BeneVivere.Repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    private final ProdutosRepository produtosRepository;

    @Autowired
    public ProdutosService(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    // Método para buscar todos os produtos
    public List<Produtos> buscarTodos() {
        return produtosRepository.findAll();
    }

    // Método para buscar um produto por ID
    public Optional<Produtos> buscarPorId(Long id) {
        return produtosRepository.findById(id);
    }

    // Método para adicionar um novo produto
    public Produtos adicionarProduto(Produtos produto) {
        return produtosRepository.save(produto);
    }

    // Método para editar um produto existente
    public Produtos editarProduto(Long id, Produtos produtoAtualizado) {
        return produtosRepository.findById(id)
                .map(produto -> {
                    produto.setCodigoProduto(produtoAtualizado.getCodigoProduto());
                    produto.setDataFabricacao(produtoAtualizado.getDataFabricacao());
                    produto.setDataValidade(produtoAtualizado.getDataValidade());
                    produto.setPreco(produtoAtualizado.getPreco());
                    produto.setTipoProduto(produtoAtualizado.getTipoProduto());
                    produto.setComponentePrincipal(produtoAtualizado.getComponentePrincipal());
                    produto.setComponenteSecundario(produtoAtualizado.getComponenteSecundario());
                    produto.setMarca(produtoAtualizado.getMarca());
                    produto.setPeso(produtoAtualizado.getPeso());
                    produto.setUnidadeMedida(produtoAtualizado.getUnidadeMedida());
                    produto.setFabricante(produtoAtualizado.getFabricante());
                    return produtosRepository.save(produto);
                })
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    // Método para remover um produto por ID
    public void removerProdutos(Long id) {
        produtosRepository.deleteById(id);
    }
}
