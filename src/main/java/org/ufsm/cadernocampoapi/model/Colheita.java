package org.ufsm.cadernocampoapi.model;

import jakarta.persistence.*;

@Entity
public class Colheita {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JoinColumn(name = "anotacao_id", nullable = false)
    private Anotacao anotacao;

    @Column(nullable = false)
    private UnidadeMedida unidadeMedida;
    @Column(nullable = false)
    private double quantidade;


    @ManyToOne
    @JoinColumn(name = "destinoId", nullable = false)
    private Destino destino;



}
