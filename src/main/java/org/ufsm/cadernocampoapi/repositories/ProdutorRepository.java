    package org.ufsm.cadernocampoapi.repositories;

    import org.springframework.data.jpa.repository.JpaRepository;
    import org.ufsm.cadernocampoapi.model.Produtor;

    import java.util.List;
    import java.util.Optional;


    public interface ProdutorRepository extends JpaRepository<Produtor, Long> {
        Produtor findByUsuarioId(Long usuarioId);

        Optional<Produtor> findByUsuarioEmail(String email);

    }
