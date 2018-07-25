package com.standby.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EstoqueDTO implements Serializable {

    private Long id;
    private Long produtoId;
    private Integer quantidade;
}
