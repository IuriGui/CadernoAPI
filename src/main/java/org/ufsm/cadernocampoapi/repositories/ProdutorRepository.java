package org.ufsm.cadernocampoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ufsm.cadernocampoapi.model.Produtor;

public interface ProdutorRepository extends JpaRepository<Produtor, Long> {
}
