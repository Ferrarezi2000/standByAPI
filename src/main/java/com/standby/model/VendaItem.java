package com.standby.model;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(catalog = "stand_by", name = "venda_item")
@EqualsAndHashCode
public class VendaItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_venda")
    private Venda venda;

    private String produto;

    private BigDecimal valor;
}