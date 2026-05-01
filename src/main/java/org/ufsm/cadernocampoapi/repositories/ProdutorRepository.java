package org.ufsm.cadernocampoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ufsm.cadernocampoapi.model.Produtor;

import java.util.List;


public interface ProdutorRepository extends JpaRepository<Produtor, Long> {
    List<Produtor> findByUsuarioId(Long usuarioId);
}
