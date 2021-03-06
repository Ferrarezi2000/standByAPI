package com.standby.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class DespesaDTO implements Serializable {

    private Long id;
    private String descricao;
    private Date dataVencimento;
    private BigDecimal valor;
    private Boolean pago;
}
