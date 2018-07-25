package com.standby.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoDTO implements Serializable {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private Integer quantidadeVendida;
}
