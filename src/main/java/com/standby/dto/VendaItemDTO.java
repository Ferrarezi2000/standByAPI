package com.standby.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class VendaItemDTO implements Serializable {

    private Long id;
    private Long vendaId;
    private String produto;
    private BigDecimal valor;
}
