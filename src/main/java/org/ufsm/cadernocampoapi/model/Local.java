package org.ufsm.cadernocampoapi.model;


import jakarta.persistence.*;

import java.util.List;


@Entity
public class Local {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private TipoLocalEnum tipo;

    @Column(nullable = false)
    private double areaEmMetros;
    @Column(nullable = false)
    private boolean quebraVento;
    @Column(nullable = false)
    private boolean areaSensivel;
    private String observacoes;


    @ManyToOne
    @JoinColumn(name = "propriedadeId")
    private Propriedade propriedade;


    @OneToMany(mappedBy = "local")
    private List<AreaCultivo> areasCultivo;




}
