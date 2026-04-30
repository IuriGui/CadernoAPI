package org.ufsm.cadernocampoapi.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class AreaCultivo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "localId")
    private Local local;

    @Column(nullable = false)
    @OneToMany(mappedBy = "areaCultivo")
    private List<Anotacao> caderno;

}
