package com.standby.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ClienteDTO implements Serializable {

    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
}
