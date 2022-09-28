package br.edu.infnet.appos.model.repository;

import br.edu.infnet.appos.model.domain.Solicitante;
import br.edu.infnet.appos.model.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitanteRepository extends JpaRepository<Solicitante, Integer> {
    List<Solicitante> findSolicitanteByUsuario(Usuario usuario);
}
