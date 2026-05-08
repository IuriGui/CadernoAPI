package org.ufsm.cadernocampoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ufsm.cadernocampoapi.model.Insumo;

public interface InsumoRepository extends JpaRepository<Insumo, Long> {
}
