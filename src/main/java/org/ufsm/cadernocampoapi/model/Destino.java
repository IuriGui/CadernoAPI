package org.ufsm.cadernocampoapi.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Destino {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @OneToMany(mappedBy = "destino")
    private List<Colheita> colheita;



}
