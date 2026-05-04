package org.ufsm.cadernocampoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ufsm.cadernocampoapi.model.Anotacao;

public interface AnotacaoRepository extends JpaRepository<Anotacao, Long> {
}
