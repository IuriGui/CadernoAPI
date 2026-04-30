package org.ufsm.cadernocampoapi.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Date;

@Entity
public class Anotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "areaCultivoId")
    private AreaCultivo areaCultivo;

    @Column(nullable = false)
    private Date dataCriacao;

    private UnidadeMedida unidadeMedida;
    private double quantidade;

    @ManyToOne
    @JoinColumn(name = "atividadeId", nullable = false)
    private Atividade atividade;

    @ManyToOne
    @JoinColumn(name = "insumoId")
    private Insumo insumo;

    @ManyToOne
    @JoinColumn(name = "culturaId")
    private Cultura cultura;

    @OneToOne(mappedBy = "anotacao")
    private Colheita colheita;



}
