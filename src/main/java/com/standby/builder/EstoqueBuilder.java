package com.standby.builder;

import com.standby.dto.EstoqueDTO;
import com.standby.model.Estoque;
import com.standby.model.Produto;
import com.standby.repository.EstoqueRepository;
import com.standby.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstoqueBuilder {

    @Autowired private EstoqueRepository repository;
    @Autowired private ProdutoRepository produtoRepository;

    public Estoque build(Estoque estoque, EstoqueDTO dto) {

        Produto produto = produtoRepository.findOne(dto.getProdutoId());
        Estoque estoqueEncontrado = repository.findByProduto(produto);

        if (estoqueEncontrado != null) {
            Integer total = estoqueEncontrado.getQuantidade() + dto.getQuantidade();
            estoqueEncontrado.setQuantidade(total);
            repository.save(estoqueEncontrado);
        } else {
            estoque.setProduto(produto);
            estoque.setQuantidade(dto.getQuantidade());

            repository.save(estoque);
        }
        return estoque;
    }
}
