package org.ufsm.cadernocampoapi.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
public class Insumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String produto;
    @Column(nullable = false)
    private String fornecedor;

    @Column(nullable = false)
    private Date dataAquisicao;

    @ManyToOne
    @JoinColumn(name = "propriedadeId")
    private Propriedade propriedade;


}
