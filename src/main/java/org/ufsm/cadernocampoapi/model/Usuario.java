package org.ufsm.cadernocampoapi.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Produtor produtor;

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;


    public Usuario() {

    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", produtor=" + produtor +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
