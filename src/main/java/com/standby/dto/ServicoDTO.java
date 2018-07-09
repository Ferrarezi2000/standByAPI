package com.standby.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ServicoDTO implements Serializable {

    private Long id;
    private Long clienteId;
    private String descricao;
    private BigDecimal valor;
    private Date dataSolicitacao;
    private String status;
    private Boolean cancelado;
    private String motivoCancelamento;
    private Boolean pago;
    private String numeroControle;
}
