package org.ufsm.cadernocampoapi.model;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String tipo; // Ver depois

}
