package com.standby.builder;

import com.standby.dto.VendaDTO;
import com.standby.model.*;
import com.standby.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class VendaBuilder {

    @Autowired private VendaRepository repository;
    @Autowired private ClienteRepository clienteRepository;
    @Autowired private VendaItemRepository vendaItemRepository;
    @Autowired private EstoqueRepository estoqueRepository;
    @Autowired private ProdutoRepository produtoRepository;

    public Venda build(Venda venda, VendaDTO dto) {

        Cliente cliente = clienteRepository.findOne(dto.getClienteId());

        venda.setCliente(cliente);
        venda.setDataVenda(new Date());
        venda.setValor(dto.getValor());
        venda.setSacado(false);

        repository.save(venda);

        dto.getProdutos().forEach(item -> {
            Produto produto = produtoRepository.findOne(item.getId());
            VendaItem vendaItem = new VendaItem();
            vendaItem.setProduto(item.getNome());
            vendaItem.setDescricao(item.getDescricao());
            vendaItem.setQuantidadeVendida(item.getQuantidadeVendida());
            vendaItem.setValor(item.getValor());
            vendaItem.setVenda(venda);
            vendaItemRepository.save(vendaItem);

            Estoque estoque = estoqueRepository.findByProduto(produto);
            Integer total = estoque.getQuantidade() - item.getQuantidadeVendida();
            estoque.setQuantidade(total);
            estoqueRepository.save(estoque);

        });

        return venda;
    }
}
