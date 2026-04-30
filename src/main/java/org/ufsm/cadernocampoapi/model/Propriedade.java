package org.ufsm.cadernocampoapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Propriedade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private Double areaTotal;

    @Column(nullable = false)
    private Double areaPropria;

    private String observacao;
    private Double areaArrendada;
    private Double areaProducaoVegetal;

    @OneToMany(mappedBy = "propriedade")
    private List<Insumo> insumos;

    @OneToMany(mappedBy = "propriedade")
    private List<Local> locais;

    @Column(nullable = false)
    @OneToMany(mappedBy = "propriedade")
    private List<ProdutorPropriedade> produtores;


}
