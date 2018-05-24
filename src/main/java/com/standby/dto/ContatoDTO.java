package com.standby.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ContatoDTO implements Serializable {

    private Long id;
    private String numero;
    private Long clienteId;
}
