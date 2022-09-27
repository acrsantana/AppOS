package br.edu.infnet.appos.model.repository;

import br.edu.infnet.appos.model.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Boolean existsByEmail(String email);
    Optional<Usuario> findByEmail(String email);
}
