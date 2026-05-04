package org.ufsm.cadernocampoapi.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Setter
@Getter
public class Local {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
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

    @Override
    public String toString() {
        return "Local{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo=" + tipo +
                ", areaEmMetros=" + areaEmMetros +
                ", quebraVento=" + quebraVento +
                ", areaSensivel=" + areaSensivel +
                ", observacoes='" + observacoes + '\'' +
                ", areasCultivo=" + areasCultivo +
                '}';
    }
}
