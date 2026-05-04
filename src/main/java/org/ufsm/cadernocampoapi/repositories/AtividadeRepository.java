package org.ufsm.cadernocampoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ufsm.cadernocampoapi.model.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
}
