package org.ufsm.cadernocampoapi.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProgramaComercializacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produtorId", nullable = false)
    @JsonIgnore
    private Produtor produtor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProgramaComercializacaoEnum tipo;

    @Column(nullable = false)
    private String valor;


}
