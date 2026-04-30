package org.ufsm.cadernocampoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ufsm.cadernocampoapi.model.Propriedade;

public interface PropriedadeRepository extends JpaRepository<Propriedade, Long> {
}
