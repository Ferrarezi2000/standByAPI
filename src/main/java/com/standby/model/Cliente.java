package com.standby.model;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(catalog = "stand_by", name = "cliente")
@EqualsAndHashCode
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String sobrenome;

    @NotEmpty
    private String cpf;

    private Date dataNascimento;

    @Transient
    private Endereco endereco;

    @Transient
    private List<Contato> contatos;

    @Transient
    private List<Servico> servicos;


}