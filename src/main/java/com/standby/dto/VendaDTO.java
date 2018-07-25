package com.standby.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class VendaDTO implements Serializable {

    private Long id;
    private Long clienteId;
    private List<ProdutoDTO> produtos;
    private BigDecimal valor;
}
