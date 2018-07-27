package com.standby.service;

import com.standby.model.Estoque;
import com.standby.model.Produto;
import com.standby.repository.EstoqueRepository;
import com.standby.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired private ProdutoRepository repository;
    @Autowired private EstoqueRepository estoqueRepository;

    public List<Produto> lista () {
        List<Produto> produtos = repository.findAll();
        List<Estoque> estoques = estoqueRepository.findAll();

        produtos.forEach(produto -> {
            estoques.forEach(estoque -> {
                produto.setVerificado(false);
                if (produto.getId().equals(estoque.getProduto().getId())) {
                    if (!produto.getVerificado()) {
                        produto.setEstoque(true);
                        produto.setVerificado(true);

                        repository.save(produto);
                    }
                }
            });
        });
        return produtos;
    }
}
