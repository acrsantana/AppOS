package br.edu.infnet.appos.model.repository;

import br.edu.infnet.appos.model.domain.OrdemServico;
import br.edu.infnet.appos.model.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Integer> {

}
