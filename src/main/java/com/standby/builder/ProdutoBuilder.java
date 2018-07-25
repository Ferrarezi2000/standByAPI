package com.standby.builder;

import com.standby.dto.ProdutoDTO;
import com.standby.model.Produto;
import com.standby.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoBuilder {

    @Autowired private ProdutoRepository repository;

    public Produto build(Produto produto, ProdutoDTO dto) {

        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setValor(dto.getValor());

        repository.save(produto);

        return produto;
    }
}
