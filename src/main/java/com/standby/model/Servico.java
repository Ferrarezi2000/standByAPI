package com.standby.model;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(catalog = "stand_by", name = "servico")
@EqualsAndHashCode
public class Servico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @NotEmpty
    private String descricao;

    private Date dataSolicitacao;

    private BigDecimal valor;

    @NotEmpty
    private String status;

    private Boolean cancelado;

    private String motivoCancelamento;

    private Boolean pago;

}