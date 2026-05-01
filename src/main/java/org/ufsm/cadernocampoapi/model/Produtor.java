package org.ufsm.cadernocampoapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produtor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(optional = false)
    @JoinColumn(name = "usuario_id", unique = true, nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private String nome;


    @OneToOne(mappedBy = "produtor", cascade = CascadeType.ALL)
    private MecanismoControle mecanismoControle;

    @OneToMany(mappedBy = "produtor", cascade = CascadeType.ALL)
    private List<ProgramaComercializacao> programaComercializacao;


    @OneToMany(mappedBy = "produtor", cascade = CascadeType.ALL)
    private List<ProdutorPropriedade> propriedade;


}
