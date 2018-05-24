package com.standby.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EnderecoDTO implements Serializable {

    private Long id;
    private String bairro;
    private String logradouro;
    private String numero;
    private String cidade;
    private Long clienteId;
}
