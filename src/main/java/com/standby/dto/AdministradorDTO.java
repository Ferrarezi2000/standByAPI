package com.standby.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class AdministradorDTO implements Serializable {

    private Long id;
    private String email;
    private String senha;
}
