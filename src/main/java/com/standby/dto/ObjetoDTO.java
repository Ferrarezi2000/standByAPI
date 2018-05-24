package com.standby.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ObjetoDTO implements Serializable {

    private ContatoDTO contatoDTO;
    private ClienteDTO clienteDTO;
    private EnderecoDTO enderecoDTO;
}
