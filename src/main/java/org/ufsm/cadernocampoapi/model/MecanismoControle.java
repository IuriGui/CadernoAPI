package org.ufsm.cadernocampoapi.model;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class MecanismoControle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JoinColumn(name = "produtorId", unique = true, nullable = false)
    private Produtor produtor;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MecanismoControleEnum tipo;

    @Column(nullable = false)
    private String valor;
}
