package org.ufsm.cadernocampoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ufsm.cadernocampoapi.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
