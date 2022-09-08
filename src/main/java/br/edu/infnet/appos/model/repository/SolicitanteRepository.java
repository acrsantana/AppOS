package br.edu.infnet.appos.model.repository;

import br.edu.infnet.appos.model.domain.Solicitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitanteRepository extends JpaRepository<Solicitante, Integer> {

}
