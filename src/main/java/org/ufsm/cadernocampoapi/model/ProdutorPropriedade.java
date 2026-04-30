package org.ufsm.cadernocampoapi.model;

import jakarta.persistence.*;

@Entity
public class ProdutorPropriedade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "propriedadeId", nullable = false)
    private Propriedade propriedade;


    @ManyToOne
    @JoinColumn(name = "produtorId", nullable = false)
    private Produtor produtor;

    @Column(nullable = false)
    private String papel;

}
